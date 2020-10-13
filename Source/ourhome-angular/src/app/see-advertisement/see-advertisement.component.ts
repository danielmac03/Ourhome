import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { HomesModel } from '../model/homes';
import { HomesService } from '../service/homes.service';

@Component({
  selector: 'app-see-advertisement',
  templateUrl: './see-advertisement.component.html',
  styleUrls: ['./see-advertisement.component.css', '../app.component.css'],
})
export class SeeAdvertisementComponent implements OnInit {
  homes: HomesModel;

  constructor(
      private route: ActivatedRoute,
      private router: Router,
      private homesService: HomesService,
  ) {}

  ngOnInit() {
    this.homes = new HomesModel();

    this.homesService.getHomesById(this.route.snapshot.params['id']).subscribe(
      (data) => {
        this.homes = data;
      },
      (error) => {
        this.router.navigate(['home']);
      }
    );
  }
}
