import { Component } from '@angular/core';
import { UsersService } from "../service/users.service";
import { AuthService } from "../service/authentication/auth.service";
import { TokenStorageService } from '../service/authentication/token-storage.service';
import { Router } from "@angular/router"

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css', '../app.component.css']
})
export class LoginComponent {

  email: string;
  password: string;

  constructor(private usersService: UsersService, private authService: AuthService, private tokenStorage: TokenStorageService, private router: Router) {}

  login() {
    let user = {email: this.email, password: this.password};

    this.authService.login(user).subscribe(
      resp => {
        this.tokenStorage.saveToken(resp.headers.get("Authorization"));

        this.usersService.getUserByEmail(this.email).subscribe(resp => {
          this.tokenStorage.saveUser(resp);
        });

        this.router.navigate(['home']);
      },
      error => {
        alert("El email o la contraseña no coincide");
      }
    );
  }

}
