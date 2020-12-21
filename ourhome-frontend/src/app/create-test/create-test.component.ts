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
      question: [''],
      correctOption: [''],
      option1: [''],
      option2: ['']
    });
  }

  add(): void{
    (this.form.controls.questions as FormArray).push(this.createQuestion());
  }

  save(): void{
    const user = this.tokenStorageService.getUser();

    const questions: string[] = [];
    const correctOptions: string[] = [];
    const options1: string[] = [];
    const options2: string[] = [];

    if (this.form.value.questions[0].question !== '' || this.form.value.questions[0].correctOption !== '' || this.form.value.questions[0].option1 !== '' || this.form.value.questions[0].option2 !== ''){
      for (const question of this.form.value.questions){
        if (question.question === '' || question.correctOption === '' || question.option1 === '' || question.option2 === ''){
          continue;
        }

        questions.push(question.question);
        correctOptions.push(question.correctOption);
        options1.push(question.option1);
        options2.push(question.option2);
      }

      const customTest = {
        user,
        questions: questions.toString(),
        answers: correctOptions.toString(),
        options1: options1.toString(),
        options2: options2.toString()
      };

      this.customTestsService.createCustomTests(customTest).subscribe(resp => {
        console.log('Complete...');
      });
    }
  }

}
