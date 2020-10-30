import {Component, OnInit, ViewChild, ViewContainerRef, ViewEncapsulation} from '@angular/core';
import {TokenStorageService} from '../service/authentication/token-storage.service';
import * as $ from 'jQuery';

@Component({
  selector: 'app-create-test',
  templateUrl: './create-test.component.html',
  styleUrls: ['./create-test.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class CreateTestComponent implements OnInit {

  counter: number;

  constructor(
    private tokenStorageService: TokenStorageService
  ) { }

  ngOnInit(): void {
    this.counter = 1;
  }

  add(): void {
    const currentCounter = this.counter;

    if (($('#questionInput' + currentCounter).val() !== '') &&
        ($('#questionRadioTrue' + currentCounter).is(':checked') || $('#questionRadioFalse' + currentCounter).is(':checked'))){
      this.counter += 1;

      $('#container_questions').append($('#question' + currentCounter).clone());

      $('#question' + this.counter).find('input').val('');
    }else{
        alert('Aún no has acabado la pregunta anterior');
    }
  }

  save(data): void{
    const getUser = this.tokenStorageService.getUser();
    const getQuestions = [];

    console.log(data.value);
    /*  for (let i = 0; i < this.counter; i++){
      const questionInput = 'questionInput' + i;
      getQuestions.push(data.questionInput);
    }*/

    console.log(data.questionInput1);

    /*
    let test = {
      user: getUser,
      questions,
      correctAnswers,
      minimumCorrectResponses: 5,
    };
     */

  }

}
