import {Component, OnInit} from '@angular/core';
import {NgForm} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {HomesService} from '../service/homes.service';
import {ProcessesService} from '../service/processes.service';
import {CustomTestsService} from '../service/custom-tests.service';
import {TokenStorageService} from '../service/token-storage.service';

@Component({
  selector: 'app-custom-test',
  templateUrl: './custom-test.component.html',
  styleUrls: ['./custom-test.component.css'],

})
export class CustomTestComponent implements OnInit {

  home;
  customTest;
  questions = [];

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private homesService: HomesService,
    private processesService: ProcessesService,
    private customTestsService: CustomTestsService,
    private tokenStorageService: TokenStorageService
  ) {
  }

  ngOnInit(): void {
    this.homesService.getHomeById(this.route.snapshot.params.home).subscribe(resp1 => {
      this.home = resp1;

      this.customTestsService.getCustomTestsByUser(this.home.user.id).subscribe(resp2 => {
        this.questions = JSON.parse(resp2.questions);
      });
    });
  }

  save(data: NgForm): void {
    const user = this.tokenStorageService.getUser();
    let common = 0;

    for (let i = 0; i < Object.values(data.value).length; i++) {
      if (Object.values(data.value)[i] === this.questions[i].correctOption.toString()) {
        common++;
      }
    }

    const process = {
      home: this.home,
      user,
      answers: Object.values(data.value).toString(),
      compatibility: (common / this.questions.length) * 10,
      state: 1
    };

    this.processesService.createProcess(process).subscribe(resp => {
      this.router.navigate(['list-processes']);
    });
  }

}
