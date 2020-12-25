import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { UsersService } from '../service/users.service';
import { TokenStorageService } from '../service/token-storage.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  email: string;
  password: string;

  constructor(
    private router: Router,
    private usersService: UsersService,
    private tokenStorageService: TokenStorageService
  ) {}

  login(): void {
    const user = {email: this.email, password: this.password};

    this.usersService.getAuthorization(user).subscribe(
      respHeader => {
        this.tokenStorageService.saveToken(respHeader.headers.get('Authorization'));

        this.usersService.getUserByEmail(this.email).subscribe(respUser => {
          this.tokenStorageService.saveUser(respUser);
        });

        this.router.navigate(['home']);
      },
      error => {
        alert('El email o la contraseña no coincide');
      }
    );
  }

}
