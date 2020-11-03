import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ProcessesService } from '../service/processes.service';
import { TokenStorageService } from '../service/authentication/token-storage.service';

@Component({
  selector: 'app-see-requests',
  templateUrl: './see-requests.component.html',
  styleUrls: ['./see-requests.component.css']
})
export class SeeRequestsComponent implements OnInit {

  home;
  users;

  constructor(
    private route: ActivatedRoute,
    private processesService: ProcessesService,
    private tokenStorageService: TokenStorageService
  ) { }

  ngOnInit(): void {
    this.processesService.listProcessByHome(this.route.snapshot.params.home).subscribe(
      resp => {
          this.users = resp;
          this.home = resp[0].home;
      }, error => {
        console.log('Error...');
      });
  }

  existeComprobarCompatibilidad(defaultTestResponses: string): boolean{
    const user = this.tokenStorageService.getUser();

    const userDefaultTestResponses = user.defaultTestResponses;
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
