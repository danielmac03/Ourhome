import { Component, OnInit } from '@angular/core';
import { Router } from "@angular/router";
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
  user: Object;

  constructor(private homesService: HomesService, private router: Router, private tokenStorage: TokenStorageService) { }

  ngOnInit() { }

  save() {
    this.user = this.tokenStorage.getUser();

    let homes = {description: this.description, price: this.price, urlPhotos: this.urlPhotos, numBedrooms: this.numBedrooms, numBathroom: this.numBathroom, city: this.city, direction: this.direction, meters: this.meters, floors: this.floors, additional: this.additional, user: this.user};

    this.homesService.createHomes(homes).subscribe((data :any) => {
      this.router.navigate(['/seeAdvertisement/', data.id]);
    },
    error => console.log(error))
  }

}
