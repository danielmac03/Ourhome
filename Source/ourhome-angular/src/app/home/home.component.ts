import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
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

  constructor(private homesService: HomesService, private router: Router) { }

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.homes = this.homesService.getHomesList();
  }

  homesDetail(id: number){
    this.router.navigate(['details', id]);
  }

}
