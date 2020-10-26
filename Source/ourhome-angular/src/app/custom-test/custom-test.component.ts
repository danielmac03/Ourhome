import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { custom_tests } from '../model/custom_tests';
import { CustomTestsService } from '../service/custom-tests.service';

@Component({
  selector: 'app-custom-test',
  templateUrl: './custom-test.component.html',
  styleUrls: ['./custom-test.component.css'],

})
export class CustomTestComponent implements OnInit {

  /*
  custom_tests: custom_tests = new custom_tests();
  submitted = false;
  */

  constructor(
    private router: Router,
    private customTestsService: CustomTestsService
  ) { }

  ngOnInit(): void {
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
