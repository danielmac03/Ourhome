import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { HomesService } from '../service/homes.service';
import { TokenStorageService } from '../service/authentication/token-storage.service';
import { CheckCompatibilityHelper } from '../helpers/check-compatibility.helper';

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
  ) { }

  ngOnInit(): void {
    if (this.route.snapshot.params.city){
      this.homes = this.homesService.getHomesByCity(this.route.snapshot.params.city);
    }else{
      this.homes = this.homesService.getHomes();
    }
  }

  checkCompatibility(defaultTestResponses: string): boolean {
    return this.checkCompatibilityHelper.check(defaultTestResponses);
  }

}
