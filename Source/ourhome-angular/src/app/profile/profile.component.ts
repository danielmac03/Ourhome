import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TokenStorageService } from '../service/authentication/token-storage.service';
import { UsersService } from '../service/users.service';
import { AuthService } from '../service/authentication/auth.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  user;

  constructor(
    private tokenStorageService: TokenStorageService,
    private router: Router,
    private usersService: UsersService
  ) { }

  ngOnInit(): void {
    this.user = this.tokenStorageService.getUser();
  }

  onSubmit(form): void{
    this.user = Object.assign(this.user, form.value);

    this.usersService.updateUser(this.user).subscribe(resp => {
      console.log(resp);
    }, error => {
      console.log('Error...');
    });
  }

}
