import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {FormArray, FormBuilder, FormGroup} from '@angular/forms';
import {CustomTestsService} from '../service/custom-tests.service';
import {TokenStorageService} from '../service/token-storage.service';

@Component({
  selector: 'app-create-test',
  templateUrl: './create-test.component.html',
  styleUrls: ['./create-test.component.css'],
})
export class CreateTestComponent implements OnInit {

  form: FormGroup;

  constructor(
    private router: Router,
    private formBuilder: FormBuilder,
    private customTestsService: CustomTestsService,
    private tokenStorageService: TokenStorageService
  ) {
  }

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

  add(): void {
    (this.form.controls.questions as FormArray).push(this.createQuestion());
  }

  save(): void {
    const user = this.tokenStorageService.getUser();
    const questions = JSON.stringify(this.form.value.questions);

    this.customTestsService.createCustomTests({user, questions}).subscribe(resp => {
      this.router.navigate(['home']);
    });
  }
}
