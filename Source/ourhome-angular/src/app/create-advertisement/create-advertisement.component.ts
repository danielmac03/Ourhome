import { Component, OnInit } from '@angular/core';
import { Router } from "@angular/router";
import { homes } from '../model/homes';
import { HomesService } from '../service/homes.service';
import { TokenStorageService } from '../service/authentication/token-storage.service'

@Component({
  selector: 'app-create-advertisement',
  templateUrl: './create-advertisement.component.html',
  styleUrls: ['./create-advertisement.component.css', '../app.component.css']
})
export class CreateAdvertisementComponent implements OnInit{

  id: number;
  description: string;
  price: number;
  urlPhotos: string;
  numBedrooms: number;
  numBathroom: number;
  city: string;
  direction: string;
  meters: number;
  floors: number;
  additional: string;
  createdAt: Date;
  updatedAt: Date;
  user: number;

  constructor(private homesService: HomesService, private router: Router, private tokenStorage: TokenStorageService) { }

  ngOnInit() { }

  save() {
    console.log(this.tokenStorage.getUser());

    this.user = this.tokenStorage.getUser().id;

    let homes = {description: this.description, price: this.price, urlPhotos: this.urlPhotos, numBedrooms: this.numBedrooms, numBathroom: this.numBathroom,
      city: this.city, direction: this.direction, meters: this.meters, floors: this.floors, additional: this.additional, user: this.user};

    console.log(homes);
    this.homesService.createHomes(homes).subscribe(data => {

      console.log(data)
      this.router.navigate(['/homes']);

    },
    error => console.log(error))
  }

}
