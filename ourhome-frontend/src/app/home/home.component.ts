import {Component, Input, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {NgForm} from '@angular/forms';
import {HomesService} from '../service/homes.service';
import {WishesService} from '../service/wishes.service';
import {ProcessesService} from '../service/processes.service';
import {TokenStorageService} from '../service/token-storage.service';
import {CheckCompatibilityHelper} from '../helpers/check-compatibility.helper';

declare var $: any;

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {

  user;
  @Input() public homes;
  @Input() public processes;
  @Input() public btnContent;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private homesService: HomesService,
    private wishesService: WishesService,
    private processesService: ProcessesService,
    private tokenStorageService: TokenStorageService,
    private checkCompatibilityHelper: CheckCompatibilityHelper
  ) {
  }

  ngOnInit(): void {
    this.user = this.tokenStorageService.getUser();

    if (this.router.url.includes('/home')) {
      this.homesService.getActiveHomes().subscribe(resp => {
        this.homes = resp;
      });
    }
  }

  filterHomes(data: NgForm): void {
    if (data.value.direction !== '' && data.value.direction !== null) {
      this.homes = this.homes.filter(home => {
        home.show = !home.direction.toLowerCase().includes(data.value.direction.toLowerCase());
        return true;
      });
    }

    if (data.value.bedrooms !== '' && data.value.bedrooms !== null) {
      this.homes = this.homes.filter(home => {
        home.show = home.bedrooms > data.value.bedrooms;
        return true;
      });
    }

    if (data.value.bathrooms !== '' && data.value.bathrooms !== null) {
      this.homes = this.homes.filter(home => {
        home.show = home.bathrooms > data.value.bathrooms;
        return true;
      });
    }

    if (data.value.floors !== '' && data.value.floors !== null) {
      this.homes = this.homes.filter(home => {
        home.show = home.floors > data.value.floors;
        return true;
      });
    }

    if (data.value.meters !== '' && data.value.meters !== null) {
      this.homes = this.homes.filter(home => {
        home.show = home.meters > data.value.meters;
        return true;
      });
    }

    if (data.value.minprice !== '' && data.value.minprice !== null) {
      this.homes = this.homes.filter(home => {
        home.show = home.price < data.value.minprice;
        return true;
      });
    }

    if (data.value.maxprice !== '' && data.value.maxprice !== null) {
      this.homes = this.homes.filter(home => {
        home.show = home.price > data.value.maxprice;
        return true;
      });
    }
  }

  addWish(home: object): void {
    if (this.user.role === 'search') {
      const wish = {
        user: this.user,
        home
      };

      this.wishesService.saveWish(wish).subscribe();
    }
  }

  removeWish(homeId: number): void {
    if (this.user.role === 'search') {
      this.wishesService.deleteWish(this.user.id, homeId).subscribe();
    }
  }

  checkCompatibility(defaultTestResponses: string): boolean {
    return this.checkCompatibilityHelper.check(defaultTestResponses);
  }

  deleteProcess(idProcess: number, divId: string): void {
    this.processesService.deleteProcesses(idProcess, this.user.role).subscribe(resp => {
      $(divId).remove();
    });
  }

}
