import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { UsersService } from '../service/users.service';
import { AuthService } from '../service/authentication/auth.service';
import { TokenStorageService } from '../service/authentication/token-storage.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  email: string;
  password: string;

  constructor(
    private usersService: UsersService,
    private authService: AuthService,
    private tokenStorageService: TokenStorageService,
    private router: Router
  ) {}

  login(): void {
    const user = {email: this.email, password: this.password};

    this.authService.login(user).subscribe(
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
