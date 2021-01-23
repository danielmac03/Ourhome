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

  user;
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
    this.user = this.tokenStorageService.getUser();

    this.processesService.existProcess(this.route.snapshot.params.home, this.user.id).subscribe(resp1 => {
      if (!resp1) {
        this.homesService.getHomeById(this.route.snapshot.params.home).subscribe(resp1 => {
          this.home = resp1;

          this.customTestsService.getCustomTestsByUser(this.home.user.id).subscribe(resp2 => {
            if (resp2 != null) {
              this.questions = JSON.parse(resp2.questions);
            } else {
              const process = {
                home: this.home,
                user: this.user,
                compatibility: -1,
                state: 1
              };

              this.processesService.createProcess(process).subscribe(resp => {
                this.router.navigate(['list-processes']);
              });
            }
          });
        });
      }else{
        this.router.navigate(['list-processes']);
      }
    });
  }

  save(data: NgForm): void {
    let common = 0;

    for (let i = 0; i < Object.values(data.value).length; i++) {
      if (Object.values(data.value)[i] === this.questions[i].correctOption.toString()) {
        common++;
      }
    }

    const process = {
      home: this.home,
      user: this.user,
      answers: Object.values(data.value).toString(),
      compatibility: (common / this.questions.length) * 10,
      state: 1
    };

    this.processesService.createProcess(process).subscribe(resp => {
      this.router.navigate(['list-processes']);
    });
  }

}
