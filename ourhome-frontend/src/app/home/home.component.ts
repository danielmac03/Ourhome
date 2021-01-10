import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {NgForm} from '@angular/forms';
import {HomesService} from '../service/homes.service';
import {TokenStorageService} from '../service/token-storage.service';
import {CheckCompatibilityHelper} from '../helpers/check-compatibility.helper';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  homes;
  filterHomes;

  constructor(
    private homesService: HomesService,
    private router: Router,
    private route: ActivatedRoute,
    private tokenStorageService: TokenStorageService,
    private checkCompatibilityHelper: CheckCompatibilityHelper
  ) {
  }

  ngOnInit(): void {
    this.homesService.getActiveHomes().subscribe(resp => {
      this.homes = resp;
      this.filterHomes = resp;
    });
  }

  onSubmit(data: NgForm): void {
    this.filterHomes = this.homes;

    if (data.value.direction !== '' && data.value.direction !== null) {
      console.log(data.value.direction);
      this.filterHomes = this.filterHomes.filter(home => home.direction.toLowerCase().includes(data.value.direction.toLowerCase()));
    }

    if (data.value.bedrooms !== '' && data.value.bedrooms !== null) {
      this.filterHomes = this.filterHomes.filter(home => home.bedrooms <= data.value.bedrooms);
    }

    if (data.value.bathrooms !== '' && data.value.bathrooms !== null) {
      this.filterHomes = this.filterHomes.filter(home => home.bathrooms <= data.value.bathrooms);
    }

    if (data.value.floors !== '' && data.value.floors !== null) {
      this.filterHomes = this.filterHomes.filter(home => home.floors <= data.value.floors);
    }

    if (data.value.meters !== '' && data.value.meters !== null) {
      this.filterHomes = this.filterHomes.filter(home => home.meters <= data.value.meters);
    }

    if (data.value.minprice !== '' && data.value.minprice !== null) {
      this.filterHomes = this.filterHomes.filter(home => home.price >= data.value.minprice);
    }

    if (data.value.maxprice !== '' && data.value.maxprice !== null) {
      console.log(1);
      this.filterHomes = this.filterHomes.filter(home => home.price <= data.value.maxprice);
    }
  }

  checkCompatibility(defaultTestResponses: string): boolean {
    return this.checkCompatibilityHelper.check(defaultTestResponses);
  }
}
