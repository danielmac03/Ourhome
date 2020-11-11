import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HomesService } from '../service/homes.service';
import { ProcessesService } from '../service/processes.service';
import { TokenStorageService } from '../service/authentication/token-storage.service';

@Component({
  selector: 'app-see-requests',
  templateUrl: './see-requests.component.html',
  styleUrls: ['./see-requests.component.css']
})
export class SeeRequestsComponent implements OnInit {

  home;
  user;
  users;

  constructor(
    private route: ActivatedRoute,
    private homesService: HomesService,
    private processesService: ProcessesService,
    private tokenStorageService: TokenStorageService
  ) { }

  ngOnInit(): void {
    this.user = this.tokenStorageService.getUser();

    if (this.route.snapshot.params.home) {
      this.homesService.getHomesById(this.route.snapshot.params.home).subscribe(
      resp => {
        this.home = resp;
        this.listProcesses();
      }, error => {
        console.log('Error...');
      });
    } else {
      this.homesService.getHomesByUser(this.user.id).subscribe(
      resp => {
        this.home = resp[0];
        this.listProcesses();
      }, error => {
        console.log('Error...');
      });
    }
  }

  listProcesses(): void{
    this.processesService.listProcessByHome(this.home.id).subscribe(
    resp => {
      this.users = resp;
    }, error => {
      console.log('Error...');
    });
  }


  existeComprobarCompatibilidad(defaultTestResponses: string): boolean{
    const userDefaultTestResponses = this.user.defaultTestResponses;
    const defaultTestResponsesString = defaultTestResponses;

    let contador = 0;
    for (let i = 0; i < userDefaultTestResponses.length; i++){
      if (defaultTestResponsesString.charAt(i) === userDefaultTestResponses.charAt(i)){
        contador++;
      }
    }

    if (contador < userDefaultTestResponses.length / 2){
      return false;
    }

    return true;
  }

}
