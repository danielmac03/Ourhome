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

  constructor(
    private homesService: HomesService,
    private router: Router,
    private route: ActivatedRoute,
    private tokenStorageService: TokenStorageService
  ) {
  }

  ngOnInit(): void {
    this.homesService.getHomeById(this.route.snapshot.params.id).subscribe(resp => {
      this.home = resp;
      console.log(this.home);
    }, error => {
      console.log('Error...');
    });
  }

  onSubmit(data: NgForm): void {
    data.value.id = this.route.snapshot.params.id;
    data.value.user = this.tokenStorageService.getUser();


    this.homesService.updateHomes(data.value).subscribe(resp => {
      this.router.navigate(['see-advertisement', this.route.snapshot.params.id]);
    }, error => {
      console.log(error);
    });
  }

}
