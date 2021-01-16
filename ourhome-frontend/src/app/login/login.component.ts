import {Component} from '@angular/core';
import {Router} from '@angular/router';
import {NgForm} from '@angular/forms';
import {UsersService} from '../service/users.service';
import {TokenStorageService} from '../service/token-storage.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  constructor(
    private router: Router,
    private usersService: UsersService,
    private tokenStorageService: TokenStorageService
  ) {
  }

  onSubmit(data: NgForm): void {
    this.usersService.getAuthorization(data.value).subscribe(
      respHeader => {
        this.tokenStorageService.saveToken(respHeader.headers.get('Authorization'));

        this.usersService.getUserByEmail(data.value.email).subscribe(respUser => {
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
