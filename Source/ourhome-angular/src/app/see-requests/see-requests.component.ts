import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HomesService } from '../service/homes.service';
import { ProcessesService } from '../service/processes.service';
import { CustomTestsService } from '../service/custom-tests.service';
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
  questions = [];

  constructor(
    private route: ActivatedRoute,
    private homesService: HomesService,
    private processesService: ProcessesService,
    private customTestsService: CustomTestsService,
    private tokenStorageService: TokenStorageService,
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
      console.log(resp);
      this.users = resp;
    }, error => {
      console.log('Error...');
    });

    this.customTestsService.getCustomTestsByUser(this.home.id).subscribe(
  resp => {

    for (let i = 0; i < resp.questions.split(',').length; i++){
      this.questions.push({
        question: resp.questions.split(',')[i],
        option1: resp.options1.split(',')[i],
        option2: resp.options2.split(',')[i]
      });
    }

    console.log(this.questions);
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
