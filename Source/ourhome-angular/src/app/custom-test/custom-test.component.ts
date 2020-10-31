import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import { custom_tests } from '../model/custom_tests';
import { CustomTestsService } from '../service/custom-tests.service';

@Component({
  selector: 'app-custom-test',
  templateUrl: './custom-test.component.html',
  styleUrls: ['./custom-test.component.css'],

})
export class CustomTestComponent implements OnInit {

  questions = [];

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private customTestsService: CustomTestsService
  ) { }

  ngOnInit(): void {
    this.customTestsService.getCustomTestsByUser(this.route.snapshot.params.home).subscribe(resp => {
      for (let i = 0; i < resp.questions.split(',').length; i++){
        this.questions.push({
          question: resp.questions.split(',')[i],
          answer: resp.answers.split(',')[i],
          option1: resp.options1.split(',')[i],
          option2: resp.options2.split(',')[i]
        });
      }
    }, error => {
      console.log('Error...');
    });
  }

  /*
  save(): void {
    this.customTestsService
    .createCustomTests(this.custom_tests).subscribe(data => {
      console.log(data)
      this.custom_tests = new custom_tests();
      this.router.navigate(['home']);
    },
    error => console.log(error));
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }
   */

}
