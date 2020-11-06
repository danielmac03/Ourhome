import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TokenStorageService } from '../service/authentication/token-storage.service';
import { UsersService } from '../service/users.service';
import { AuthService } from '../service/authentication/auth.service';
import {NgForm} from "@angular/forms";

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  user;

  constructor(
    private tokenStorageService: TokenStorageService,
    private authService: AuthService,
    private route: ActivatedRoute,
    private router: Router,
    private usersService: UsersService
  ) { }

  ngOnInit(): void {
    this.user = this.tokenStorageService.getUser();
  }

  onSubmit(form: NgForm): void{
    console.log(form.value);
  }

/*
  updateUser() {
    const user = {
      name: this.name,
      surnames: this.surnames,
      age: this.age,
      email: this.email,
      password: this.password,
      role: this.role,
      showPhone: this.showPhone
    };

    this.tokenStorageService.saveUser(user);
    this.router.navigate(['initialTest']);
  }
*/
}
