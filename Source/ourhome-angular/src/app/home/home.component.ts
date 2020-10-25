import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { HomesService } from '../service/homes.service';
import { TokenStorageService } from '../service/authentication/token-storage.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css', '../app.component.css']
})
export class HomeComponent implements OnInit {

  homes;

  constructor(
    private homesService: HomesService,
    private router: Router,
    private route: ActivatedRoute,
    private tokenStorageService: TokenStorageService
  ) { }

  ngOnInit(): void {
    if (this.route.snapshot.params.city){
      this.homes = this.homesService.getHomesByCity(this.route.snapshot.params.city);
    }else{
      this.homes = this.homesService.getHomes();
    }
  }

  existeComprobarCompatibilidad(defaultTestResponses: string): boolean {
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

}
