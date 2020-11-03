import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ProcessesService } from '../service/processes.service';
import { HomesService } from '../service/homes.service';
import { TokenStorageService } from '../service/authentication/token-storage.service';

@Component({
  selector: 'app-processes',
  templateUrl: './processes.component.html',
  styleUrls: ['./processes.component.css']
})
export class ProcessesComponent implements OnInit {

  user = this.tokenStorageService.getUser();
  processes;
  homes;

  constructor(
    private processesService: ProcessesService,
    private router: Router,
    private homesService: HomesService,
    private tokenStorageService: TokenStorageService
  ) { }

  ngOnInit(): void {
    if (this.user.role === 'search'){
      this.processes = this.processesService.listProcessByUser(this.user.id);
    }else if (this.user.role === 'have') {
      this.homesService.getHomesByUser(this.user.id).subscribe(
        resp1 => {
          this.processesService.listProcessByHome(resp1[0].id).subscribe(
            resp2 => {
              this.processes = resp2;
            }, error => {
              console.log('Error...');
          });
        },
        error => {
          this.router.navigate(['home']);
        }
      );
    } else if (this.user.role === 'business'){
      this.homesService.getHomesByUser(this.user.id).subscribe(
        resp => {
          this.homes = resp;
        },
        error => {
          this.router.navigate(['home']);
        }
      );
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
