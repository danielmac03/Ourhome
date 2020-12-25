import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {HomesService} from '../service/homes.service';
import {ProcessesService} from '../service/processes.service';
import {CustomTestsService} from '../service/custom-tests.service';
import {TokenStorageService} from '../service/token-storage.service';
import {CheckCompatibilityHelper} from '../helpers/check-compatibility.helper';
import * as $ from 'jquery';

@Component({
  selector: 'app-see-requests',
  templateUrl: './see-requests.component.html',
  styleUrls: ['./see-requests.component.css']
})
export class SeeRequestsComponent implements OnInit {

  home;
  user;
  users;
  questions = [];

  constructor(
    private route: ActivatedRoute,
    private homesService: HomesService,
    private processesService: ProcessesService,
    private customTestsService: CustomTestsService,
    private tokenStorageService: TokenStorageService,
    private checkCompatibilityHelper: CheckCompatibilityHelper
  ) {
  }

  ngOnInit(): void {
    this.user = this.tokenStorageService.getUser();

    if (this.route.snapshot.params.home) {
      this.homesService.getHomeById(this.route.snapshot.params.home).subscribe(
        resp => {
          this.home = resp;
          this.listProcesses();
        });
    } else {
      this.homesService.getHomesByUser(this.user.id).subscribe(
        resp => {
          this.home = resp[0];
          this.listProcesses();
        });
    }
  }

  listProcesses(): void {
    this.processesService.listProcessByHome(this.home.id).subscribe(
      resp => {
        this.users = resp;
      });

    this.customTestsService.getCustomTestsByUser(this.home.user.id).subscribe(
      resp => {
        for (let i = 0; i < resp.questions.split(',').length; i++) {
          this.questions.push({
            question: resp.questions.split(',')[i],
            option1: resp.options1.split(',')[i],
            option2: resp.options2.split(',')[i]
          });
        }
      });
  }

  checkCompatibility(defaultTestResponses: string): boolean {
    return this.checkCompatibilityHelper.check(defaultTestResponses);
  }

  deleteProcess(idProcess: number, divId: string): void {
    this.processesService.deleteProcesses(idProcess).subscribe(resp => {
      $('#' + divId).remove();

    });
  }

}
