import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {WishesService} from '../service/wishes.service';
import {TokenStorageService} from '../service/token-storage.service';
import {CheckCompatibilityHelper} from '../helpers/check-compatibility.helper';

@Component({
  selector: 'app-wishlist',
  templateUrl: './wishlist.component.html',
  styleUrls: ['./wishlist.component.css']
})
export class WishlistComponent implements OnInit {

  user;
  homes = [];

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private wishesService: WishesService,
    private tokenStorageService: TokenStorageService,
    private checkCompatibilityHelper: CheckCompatibilityHelper
  ) {
  }

  ngOnInit(): void {
    this.user = this.tokenStorageService.getUser();

    this.wishesService.searchWishesByUser(this.user.id).subscribe(resp => {
      for (const home of resp){
        this.homes.push(home.home);
      }
    });
  }

}
