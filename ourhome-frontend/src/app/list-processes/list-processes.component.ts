import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {HomesService} from '../service/homes.service';
import {ProcessesService} from '../service/processes.service';
import {TokenStorageService} from '../service/token-storage.service';

@Component({
  selector: 'app-processes',
  templateUrl: './list-processes.component.html',
  styleUrls: ['./list-processes.component.css']
})
export class ListProcessesComponent implements OnInit {

  user;
  homes = [];
  processes;

  constructor(
    private router: Router,
    private homesService: HomesService,
    private processesService: ProcessesService,
    private tokenStorageService: TokenStorageService
  ) {
  }

  ngOnInit(): void {
    this.user = this.tokenStorageService.getUser();

    if (this.user.role === 'search') {
      this.processesService.listProcessByUser(this.user.id).subscribe(resp => {
        for (const home of resp) {
          this.homes.push(home.home);
        }

        this.processes = resp;
      });
    } else if (this.user.role === 'business') {
      this.homesService.getHomesByUser(this.user.id).subscribe(resp => {
        this.homes = resp;
      });
    }
  }
}
