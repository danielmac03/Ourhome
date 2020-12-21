import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {HomesService} from '../service/homes.service';
import {CheckCompatibilityHelper} from '../helpers/check-compatibility.helper';
import {TokenStorageService} from '../service/authentication/token-storage.service';

@Component({
  selector: 'app-business-list-homes',
  templateUrl: './business-list-homes.component.html',
  styleUrls: ['./business-list-homes.component.css']
})
export class BusinessListHomesComponent implements OnInit {

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
    const user = this.tokenStorageService.getUser();

    this.homesService.getHomesByUser(user.id).subscribe(resp => {
      this.homes = resp;
    });
  }

  checkCompatibility(defaultTestResponses: string): boolean {
    return this.checkCompatibilityHelper.check(defaultTestResponses);
  }

}
