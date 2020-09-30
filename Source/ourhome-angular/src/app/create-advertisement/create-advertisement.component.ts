import { ThrowStmt } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { Router } from "@angular/router"
import { homes } from '../model/homes';
import { HomesService } from '../service/homes.service';

@Component({
  selector: 'app-create-advertisement',
  templateUrl: './create-advertisement.component.html',
  styleUrls: ['./create-advertisement.component.css', '../app.component.css']
})
export class CreateAdvertisementComponent implements OnInit{

 home: homes = new homes();


 constructor(private homesService: HomesService, private router: Router) { }

 ngOnInit () { }

  newAdvertisement(): void {
    this.home = new homes();
  }

 save () {
   this.homesService.createHomes(this.home).subscribe(data => {
      console.log(data)
      this.home = new homes();
      this.router.navigate(['/homes']);
   },
   error => console.log(error))
 }

  onSubmit () {
    this.save();
  }

}
