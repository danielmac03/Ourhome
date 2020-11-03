import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { HomesService } from '../service/homes.service';
import { TokenStorageService } from '../service/authentication/token-storage.service';

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
      private homesService: HomesService,
      private tokenStorageService: TokenStorageService
  ) {}

  ngOnInit(): void {
    this.homesService.getHomesById(this.route.snapshot.params.home).subscribe(
      (data) => {
        this.home = data;
      },
      (error) => {
        console.log('Error...');
        this.router.navigate(['home']);
      }
    );

    this.user = this.tokenStorageService.getUser();
  }

  contact(): void{
    this.router.navigate(['customTest', this.home.id]);
  }
}
