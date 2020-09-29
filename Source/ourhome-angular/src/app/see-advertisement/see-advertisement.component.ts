import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { homes } from '../model/homes';
import { HomesService } from '../service/homes.service';


@Component({
  selector: 'app-see-advertisement',
  templateUrl: './see-advertisement.component.html',
  styleUrls: ['./see-advertisement.component.css', '../app.component.css']
})
export class SeeAdvertisementComponent implements OnInit {

  home_id: number;
  Homes: homes;

  constructor(private route: ActivatedRoute, private router: Router, private homesService: HomesService) { }

  ngOnInit() {
    this.Homes = new homes();

    this.home_id = this.route.snapshot.params['home_id'];

    this.homesService.getHomes(this.home_id)
    .subscribe(data => {
      console.log(data)
      this.Homes = data;
    }, error => console.log(error));

  }

}
