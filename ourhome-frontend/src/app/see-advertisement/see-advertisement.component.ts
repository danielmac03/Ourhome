import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {DomSanitizer} from '@angular/platform-browser';
import {HomesService} from '../service/homes.service';
import {TokenStorageService} from '../service/token-storage.service';

@Component({
  selector: 'app-see-advertisement',
  templateUrl: './see-advertisement.component.html',
  styleUrls: ['./see-advertisement.component.css'],
})
export class SeeAdvertisementComponent implements OnInit {

  home;
  user;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private domSanitizer: DomSanitizer,
    private homesService: HomesService,
    private tokenStorageService: TokenStorageService
  ) {
  }

  ngOnInit(): void {
    this.user = this.tokenStorageService.getUser();

    this.homesService.getHomeById(this.route.snapshot.params.home).subscribe(data => {
      this.home = data;
      this.home.characteristics = JSON.parse(this.home.characteristics);
      this.home.direction = this.domSanitizer.bypassSecurityTrustResourceUrl('https://www.google.com/maps/embed/v1/place?key=AIzaSyB4pHuIU5cQEqWeJCz_Gfcf84YiMhpmaXw&q=' + this.home.direction.replace(' ', '+'));
    });
  }

  contact(): void {
    this.router.navigate(['custom-test', this.home.id]);
  }
}
