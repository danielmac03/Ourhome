import { Component } from '@angular/core';
import { AuthService } from "../service/authentication/auth.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css', '../app.component.css']
})
export class LoginComponent {
  email: string;
  password: string;

  constructor(public authService: AuthService) {}

  login() {
    const user = {email: this.email, password: this.password};
    this.authService.login(user).subscribe( data => {
      console.log(data.headers.get("Authorization"));
    });
  }
}
