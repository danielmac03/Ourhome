import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { CustomTestsService } from '../service/custom-tests.service';
import { TokenStorageService } from '../service/authentication/token-storage.service';
import { CustomTestsResponsesService } from '../service/custom-tests-responses.service';

@Component({
  selector: 'app-custom-test',
  templateUrl: './custom-test.component.html',
  styleUrls: ['./custom-test.component.css'],

})
export class CustomTestComponent implements OnInit {

  customTest;
  questions = [];
  answers: number[] = [];

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private customTestsService: CustomTestsService,
    private tokenStorageService: TokenStorageService,
    private customTestsResponsesService: CustomTestsResponsesService
  ) { }

  ngOnInit(): void{
    this.customTestsService.getCustomTestsByUser(this.route.snapshot.params.home).subscribe(resp => {
      this.customTest = resp;

      for (let i = 0; i < resp.questions.split(',').length; i++){
        this.questions.push({
          question: resp.questions.split(',')[i],
          option1: resp.options1.split(',')[i],
          option2: resp.options2.split(',')[i]
        });
      }

      this.answers = resp.answers.split(',');
    }, error => {
      console.log('Error...');
    });
  }

  save(data: NgForm): void{
    const user = this.tokenStorageService.getUser();
    const userAnswers = [];
    let common = 0;

    for (let i = 0; i < this.questions.length; i++){
      userAnswers.push(data.value[('question' + i)]);
    }

    for (let i = 0; i < this.answers.length; i++){
      if (this.answers[i] === userAnswers[i].toString()){
        common++;
      }
    }

    const customTestResponses = {
      user,
      customTest: this.customTest,
      answers: userAnswers.toString(),
      compatibility: (common / this.questions.length) * 10
    };

    this.customTestsResponsesService.createCustomTestsResponses(customTestResponses).subscribe(resp => {
      console.log('Complete...');
    }, error => {
      console.log('Error....');
    });

    this.router.navigate(['processes']);
  }

}
