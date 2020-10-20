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

  processes: Observable<ProcessesModel[]>;
  home: Observable <HomesModel[]>;

  constructor(
    private processesService: ProcessesService,
    private router: Router,
    private homesService: HomesService,
    private tokenStorageService: TokenStorageService
  ) { }

  ngOnInit(): void {
    const user = this.tokenStorageService.getUser();

    if (user.role === 'busco_casa'){
      this.processes = this.processesService.listProcessByUser(user.id);
    }else{
      console.log('In progress...');
    }
  }

  existeComprobarCompatibilidad(defaultTestResponses: string): boolean{
    const user = this.tokenStorageService.getUser();

    if (user != null){
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
    }else{
      return false;
    }

    return true;
  }

  /*
  processesDetail(id: number){
    this.router.navigate(['details', id]);
  }
   */

}
