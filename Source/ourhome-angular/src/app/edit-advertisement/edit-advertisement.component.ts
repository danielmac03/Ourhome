import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {NgForm} from '@angular/forms';
import {HomesService} from '../service/homes.service';
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
    private homesService: HomesService,
    private router: Router,
    private route: ActivatedRoute,
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
    data.value.id = this.home.id;
    data.value.user = this.user;

    this.homesService.updateHome(data.value).subscribe(resp => {
      this.router.navigate(['see-advertisement', this.home.id]);
    }, error => {
      console.log('Error...');
    });
  }

}
