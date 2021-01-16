import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
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
    });
  }

  getFilteredHomes(event): void{
    this.homes = event;
  }

  checkCompatibility(defaultTestResponses: string): boolean {
    return this.checkCompatibilityHelper.check(defaultTestResponses);
  }
}
