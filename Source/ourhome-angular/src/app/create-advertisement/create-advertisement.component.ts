import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { homes } from '../model/homes';
import { HomesService } from '../service/homes.service';

@Component({
  selector: 'app-create-advertisement',
  templateUrl: './create-advertisement.component.html',
  styleUrls: ['./create-advertisement.component.css', '../app.component.css']
})
export class CreateAdvertisementComponent implements OnInit {

  homes: homes = new homes();
  submitted = false;

  constructor(private homesService: HomesService, private router: Router) { }

  ngOnInit() {
  }

  newHome() :  void {
    this.submitted  = false;
    this.homes = new homes();
  }

  save() {
    this.homesService
    .createHomes(this.homes).subscribe(data => {
      console.log(data)
      this.homes = new homes();
      this.router.navigate(['home']);
      //PONER QUE REENVIE AL ANUNCIO ID
    },
    error => console.log(error));
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }

}
