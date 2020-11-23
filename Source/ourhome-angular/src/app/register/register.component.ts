import {Component} from '@angular/core';
import {Router} from '@angular/router';
import {NgForm} from '@angular/forms';
import {UsersService} from '../service/users.service';
import {AuthService} from '../service/authentication/auth.service';
import {TokenStorageService} from '../service/authentication/token-storage.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {

  constructor(
    private usersService: UsersService,
    private authService: AuthService,
    private tokenStorageService: TokenStorageService,
    private router: Router
  ) {
  }

  onSubmit(data: NgForm): void {
    this.usersService.getUserByEmail(data.value.email).subscribe(resp => {
      if (resp == null) {
        this.tokenStorageService.saveUser(data.value);
        this.router.navigate(['initial-test']);
      } else {
        alert('El email ya se ha registrado');
      }
    });
  }
}
