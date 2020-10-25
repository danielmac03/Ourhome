import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { ProcessesModel } from '../model/processes';
import { HomesModel } from '../model/homes';

import { ProcessesService } from '../service/processes.service';
import { HomesService } from '../service/homes.service';
import { TokenStorageService } from '../service/authentication/token-storage.service';

@Component({
  selector: 'app-processes',
  templateUrl: './processes.component.html',
  styleUrls: ['./processes.component.css', '../app.component.css']
})
export class ProcessesComponent implements OnInit {

  user = this.tokenStorageService.getUser();
  processes;

  constructor(
    private processesService: ProcessesService,
    private router: Router,
    private homesService: HomesService,
    private tokenStorageService: TokenStorageService
  ) { }

  ngOnInit(): void {
    if (this.user.role === 'tengo_casa'){
      this.homesService.getHomesByUser(this.user.id).subscribe(
        (data) => {
          this.processes = this.processesService.listProcessByHome(data.user.id);
        },
        (error) => {
          this.router.navigate(['home']);
        }
      );
    }else if (this.user.role === 'busco_casa'){
      this.processes = this.processesService.listProcessByUser(this.user.id);
    }
  }

  existeComprobarCompatibilidad(defaultTestResponses: string): boolean{
    if (this.user != null){
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
    }else{
      return false;
    }

    return true;
  }

}
