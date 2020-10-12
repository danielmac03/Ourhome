import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { homes } from '../model/homes';
import { HomesService } from '../service/homes.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css', '../app.component.css']
})
export class HomeComponent implements OnInit {

  homes: Observable<homes[]>;

  constructor(private homesService: HomesService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit() {
    if (this.route.snapshot.params['city']){
      this.homes = this.homesService.getHomesByCity(this.route.snapshot.params['city']);
    }else{
      this.homes = this.homesService.getHomes();
    }
  }

}
