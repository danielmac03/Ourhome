import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {HomesService} from '../service/homes.service';
import {TokenStorageService} from '../service/authentication/token-storage.service';
import {NgForm} from '@angular/forms';

@Component({
  selector: 'app-create-advertisement',
  templateUrl: './create-advertisement.component.html',
  styleUrls: ['./create-advertisement.component.css']
})
export class CreateAdvertisementComponent implements OnInit {

  constructor(
    private homesService: HomesService,
    private router: Router,
    private tokenStorage: TokenStorageService
  ) {
  }

  ngOnInit(): void {
  }

  onSubmit(data: NgForm): void {
    data.value.user = this.tokenStorage.getUser();
    data.value.active = true;

    this.homesService.createHomes(data.value).subscribe(resp => {
      this.router.navigate(['custom-test']);
    }, error => {
      console.log(error);
    });
  }

}
