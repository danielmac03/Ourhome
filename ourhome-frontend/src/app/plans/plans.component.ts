import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {UsersService} from '../service/users.service';
import {TokenStorageService} from '../service/token-storage.service';

@Component({
  selector: 'app-plans',
  templateUrl: './plans.component.html',
  styleUrls: ['./plans.component.css']
})
export class PlansComponent implements OnInit {

  constructor(
    private router: Router,
    private userService: UsersService,
    private tokenStorageService: TokenStorageService
  ) {
  }

  user;

  ngOnInit(): void {
    this.user = this.tokenStorageService.getUser();
  }

  buy(units: number): void {
    this.user.remainingPublications += units;

    const formData = new FormData();
    formData.append('user', new Blob([JSON.stringify(this.user)], {type: 'application/json'}));

    this.userService.updateUser(formData).subscribe(resp => {
      this.tokenStorageService.saveUser(resp);
      this.router.navigate(['home']);
    });
  }

}
