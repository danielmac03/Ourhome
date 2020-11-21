import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { HomesService } from '../service/homes.service';
import { ProcessesService } from '../service/processes.service';
import { CustomTestsService } from '../service/custom-tests.service';
import { TokenStorageService } from '../service/authentication/token-storage.service';

@Component({
  selector: 'app-custom-test',
  templateUrl: './custom-test.component.html',
  styleUrls: ['./custom-test.component.css'],

})
export class CustomTestComponent implements OnInit {

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private homesService: HomesService,
    private processesService: ProcessesService,
    private customTestsService: CustomTestsService,
    private tokenStorageService: TokenStorageService
  ) { }

  home;
  customTest;
  questions = [];
  answers: number[] = [];

  ngOnInit(): void{
    this.homesService.getHomesById(this.route.snapshot.params.home).subscribe(
      resp1 => {
        this.home = resp1;

        this.customTestsService.getCustomTestsByUser(this.home.user.id).subscribe(resp2 => {
          this.customTest = resp2;

          for (let i = 0; i < resp2.questions.split(',').length; i++){
            this.questions.push({
              question: resp2.questions.split(',')[i],
              option1: resp2.options1.split(',')[i],
              option2: resp2.options2.split(',')[i]
            });
          }

          this.answers = resp2.answers.split(',');
        }, error => {
          console.log('Error...');
        });
      }, error => {
        console.log('Error...');
        this.router.navigate(['home']);
      }
    );
  }

  save(data: NgForm): void{
    const user = this.tokenStorageService.getUser();
    const userAnswers = [];
    let common = 0;

    for (let i = 0; i < this.questions.length; i++){
      userAnswers.push(data.value[('question' + i)]);
    }

    if (!userAnswers.includes('')) {
      for (let i = 0; i < this.answers.length; i++) {
        if (this.answers[i] === userAnswers[i].toString()) {
          common++;
        }
      }

      const process = {
        home: this.home,
        user,
        answers: userAnswers.toString(),
        compatibility: (common / this.questions.length) * 10,
        state: 1
      };

      this.processesService.createProcess(process).subscribe(resp => {
        console.log('Complete...');
        this.router.navigate(['list-processes']);
      }, error => {
        console.log('Error....');
      });
    }else{
      console.log('Error....');
    }
  }

}
