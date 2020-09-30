import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { processes } from '../model/processes';
import { ProcessesService } from '../service/processes.service';

@Component({
  selector: 'app-processes',
  templateUrl: './processes.component.html',
  styleUrls: ['./processes.component.css', '../app.component.css']
})
export class ProcessesComponent implements OnInit {

  processes: Observable<processes[]>;

  constructor(private processesService: ProcessesService, private router: Router) { }

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.processes = this.processesService.getProcessesList();
  }

  processesDetail(id: number){
    this.router.navigate(['details', id]);
  }

}
