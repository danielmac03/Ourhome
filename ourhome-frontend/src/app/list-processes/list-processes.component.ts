import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {ProcessesService} from '../service/processes.service';
import {HomesService} from '../service/homes.service';
import {TokenStorageService} from '../service/token-storage.service';
import {CheckCompatibilityHelper} from '../helpers/check-compatibility.helper';

declare var $ : any;

@Component({
  selector: 'app-processes',
  templateUrl: './list-processes.component.html',
  styleUrls: ['./list-processes.component.css']
})
export class ListProcessesComponent implements OnInit {

  user = this.tokenStorageService.getUser();
  processes;
  homes;

  constructor(
    private router: Router,
    private homesService: HomesService,
    private processesService: ProcessesService,
    private tokenStorageService: TokenStorageService,
    private checkCompatibilityHelper: CheckCompatibilityHelper
  ) {
  }

  ngOnInit(): void {
    if (this.user.role === 'search') {
      this.processes = this.processesService.listProcessByUser(this.user.id);
    } else if (this.user.role === 'business') {
      this.homesService.getHomesByUser(this.user.id).subscribe(
        resp => {
          this.homes = resp;
        },
        error => {
          this.router.navigate(['home']);
        }
      );
    }
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
