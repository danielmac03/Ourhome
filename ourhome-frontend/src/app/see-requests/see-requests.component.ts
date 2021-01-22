import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {HomesService} from '../service/homes.service';
import {ProcessesService} from '../service/processes.service';
import {CustomTestsService} from '../service/custom-tests.service';
import {TokenStorageService} from '../service/token-storage.service';
import {CheckCompatibilityHelper} from '../helpers/check-compatibility.helper';

declare var $: any;

@Component({
  selector: 'app-see-requests',
  templateUrl: './see-requests.component.html',
  styleUrls: ['./see-requests.component.css']
})
export class SeeRequestsComponent implements OnInit {

  home = {
    id: undefined,
    direction: undefined,
    user: undefined,
    characteristics: undefined
  };
  user;

  userRequest;
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
          this.home.characteristics = JSON.parse(this.home.characteristics);
          this.listProcesses();
        });
    } else {
      this.homesService.getHomesByUser(this.user.id).subscribe(
        resp => {
          this.home = resp[0];
          this.home.characteristics = JSON.parse(this.home.characteristics);
          this.listProcesses();
        });
    }
  }

  listProcesses(): void {
    this.processesService.listProcessByHome(this.home.id).subscribe(resp => {
      this.users = resp;
      this.userRequest = 0;
    });

    this.customTestsService.getCustomTestsByUser(this.home.user.id).subscribe(resp => {
      this.questions = JSON.parse(resp.questions);
    });
  }

  viewRequest(user: number): void {
    this.userRequest = user;
  }

  checkCompatibility(defaultTestResponses: string): boolean {
    return this.checkCompatibilityHelper.check(defaultTestResponses);
  }

  deleteProcess(idProcess: number, divId: number): void {
    this.processesService.deleteProcesses(idProcess).subscribe(resp => {
      $('#process' + divId).remove();
    });
  }
}
