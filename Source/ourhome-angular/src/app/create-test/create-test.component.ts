import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import * as $ from 'jQuery';

@Component({
  selector: 'app-create-test',
  templateUrl: './create-test.component.html',
  styleUrls: ['./create-test.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class CreateTestComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
    window.sessionStorage.setItem('counter', '1');
  }

  add(): void {
    let counter: number = parseInt(sessionStorage.getItem('counter'));

    if (($('#questionInput' + counter).val() !== '') && $('input[name=\'' + ('questionRadio' + counter) + '\']:checked').val()){
      counter += 1;
      $('#counter').val(counter);

      const question =
        `<div class="form-group question p-2">
          <div class="form-group mt-3 field">
              <input type="text" id="questionInput` + counter + `" placeholder=" " class="form-control" required>
              <label class="lab" for="questionInput` + counter + `">Escribe tu pregunta</label>
          </div>

          <div class="form-check">
              <label class="form-check-label">
                  <input type="radio" class="form-check-input" name="questionRadio` + counter + `" value="1" required>Si
              </label>
          </div>
          <div class="form-check">
              <label class="form-check-label">
                  <input type="radio" class="form-check-input" name="questionRadio` + counter + `" value="0">No
              </label>
          </div>
        </div>`;

      $('#content_questions').append(question);

      window.sessionStorage.setItem('counter', counter.toString());
    }else{
        alert('Aún no has acabado la pregunta anterior');
    }
  }

  /*
  save(): void{
    const user = this.tokenStorageService.getUser();
    const counter: number = parseInt(sessionStorage.getItem('counter'));

    let test = {
      user: user,
      questions,
      correctAnswers,
      minimumCorrectResponses,
    };

    for (let i of counter){

    }
  }
   */

}
