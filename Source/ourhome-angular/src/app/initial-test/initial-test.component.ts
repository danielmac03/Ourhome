import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { UsersService } from '../service/users.service';
import { AuthService } from '../service/authentication/auth.service';
import { TokenStorageService } from '../service/authentication/token-storage.service';

@Component({
  selector: 'app-initial-test',
  templateUrl: './initial-test.component.html',
  styleUrls: ['./initial-test.component.css']
})
export class InitialTestComponent {

  p1: string;
  p2: string;
  p3: string;
  p4: string;
  p5: string;

  constructor(
    private usersService: UsersService,
    private authService: AuthService,
    private router: Router,
    private tokenStorageService: TokenStorageService
  ) {}

  save(): void{
    const user = this.tokenStorageService.getUser();

    user.defaultTestResponses = this.p1.toString() + this.p2.toString() + this.p3.toString() + this.p4.toString() + this.p5.toString();

    this.usersService.createUsers(user).subscribe(resp1 => {
      this.tokenStorageService.saveUser(resp1);

      this.authService.login({email: user.email, password: user.password}).subscribe(resp2 => {
        this.tokenStorageService.saveToken(resp2.headers.get('Authorization'));
      });

      this.router.navigate(['home']);
    });

  }

}
