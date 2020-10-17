import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TokenStorageService } from '../service/authentication/token-storage.service';
import {UsersService} from '../service/users.service';
import {AuthService} from '../service/authentication/auth.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css', '../app.component.css']
})

export class ProfileComponent implements OnInit {

  constructor(
    private tokenStorageService: TokenStorageService,
    private authService: AuthService,
    private route: ActivatedRoute,
    private router: Router,
    private usersService: UsersService
  ) {}

  user = {} as any;

  name: string;
  surnames: string;
  age: number;
  email: string;
  phone: number;
  password: string;
  role: number;
  showPhone: number;

  ngOnInit() {
    this.user = this.tokenStorageService.getUser();
  }

  update() {
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



}
