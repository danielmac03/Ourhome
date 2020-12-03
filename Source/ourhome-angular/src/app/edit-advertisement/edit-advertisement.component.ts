import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {NgForm} from '@angular/forms';
import {HomesService} from '../service/homes.service';
import {ProcessesService} from '../service/processes.service';
import {TokenStorageService} from '../service/authentication/token-storage.service';

@Component({
  selector: 'app-edit-advertisement',
  templateUrl: './edit-advertisement.component.html',
  styleUrls: ['./edit-advertisement.component.css']
})
export class EditAdvertisementComponent implements OnInit {

  home;
  user;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private homesService: HomesService,
    private processesService: ProcessesService,
    private tokenStorageService: TokenStorageService
  ) {
  }

  ngOnInit(): void {
    this.user = this.tokenStorageService.getUser();

    if (this.route.snapshot.params.id) {
      this.homesService.getHomeById(this.route.snapshot.params.id).subscribe(resp => {
        this.home = resp;
      }, error => {
        console.log('Error...');
      });
    } else {
      this.homesService.getHomesByUser(this.user.id).subscribe(resp => {
        this.home = resp[0];
      }, error => {
        console.log('Error...');
      });
    }
  }

  onSubmit(data: NgForm): void {
    let check;
    data.value.id = this.home.id;
    data.value.user = this.user;

    if (data.value.active === false) {
      check = confirm('Si desactiva este anuncio se eliminaran los procesos iniciados, esta seguro?');

      if (check === false){
        return;
      }
    }

    this.homesService.updateHome(data.value).subscribe(resp1 => {
      if (check === true) {
        this.processesService.deleteProcessesByHome(this.home.id).subscribe(resp2 => {
          console.log('Completed...');
        }, error => {
          console.log('Error...');
        });
      }

      this.router.navigate(['see-advertisement', this.home.id]);
    }, error => {
      console.log('Error...');
    });
  }

}
