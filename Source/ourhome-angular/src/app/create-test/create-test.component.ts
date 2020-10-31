import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormGroup } from '@angular/forms';
import { CustomTestsService } from '../service/custom-tests.service';
import { TokenStorageService } from '../service/authentication/token-storage.service';

@Component({
  selector: 'app-create-test',
  templateUrl: './create-test.component.html',
  styleUrls: ['./create-test.component.css'],
})
export class CreateTestComponent implements OnInit {

  form: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private customTestsService: CustomTestsService,
    private tokenStorageService: TokenStorageService
  ) { }

  ngOnInit(): void {
    this.form = this.formBuilder.group({
      questions: this.formBuilder.array([this.createQuestion()])
    });
  }

  createQuestion(): FormGroup {
    return this.formBuilder.group({
      questionInput: [''],
      questionRadio: ['']
    });
  }

  add(): void{
    (this.form.controls.questions as FormArray).push(this.createQuestion());
  }

  save(): void{
    const user = this.tokenStorageService.getUser();

    const questions: string[] = [];
    const answers: string[] = [];

    for (const question of this.form.value.questions){
      questions.push(question.questionInput);
      answers.push(question.questionRadio);
    }

    const customTest = {
      user,
      questions: questions.toString(),
      answers: answers.toString()
    };

    this.customTestsService.createCustomTests(customTest).subscribe(resp => {
      console.log('Complete...');
    }, error => {
      console.log('Error...');
    });
  }

  /*
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
  }*/


}
