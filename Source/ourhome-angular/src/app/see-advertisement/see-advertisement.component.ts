import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { HomesService } from '../service/homes.service';
import { TokenStorageService } from '../service/authentication/token-storage.service';
import { ProcessesService } from '../service/processes.service';

@Component({
  selector: 'app-see-advertisement',
  templateUrl: './see-advertisement.component.html',
  styleUrls: ['./see-advertisement.component.css'],
})
export class SeeAdvertisementComponent implements OnInit {

  home;

  constructor(
      private router: Router,
      private route: ActivatedRoute,
      private homesService: HomesService,
      private tokenStorageService: TokenStorageService,
      private processesService: ProcessesService
  ) {}

  ngOnInit(): void {
    const paramId = 'id';

    this.homesService.getHomesById(this.route.snapshot.params[paramId]).subscribe(
      (data) => {
        this.home = data;
      },
      (error) => {
        console.log('Error...');
        this.router.navigate(['home']);
      }
    );
  }

  contact(): void{
    const getUser = this.tokenStorageService.getUser();

    const process = {
      home: this.home,
      user: getUser,
      state: 1
    };

    this.processesService.createProcess(process).subscribe(
      (resp) => {
        console.log('Exito...');
      },
      (error) => {
        console.log('Error...');
      }
    );
  }
}
