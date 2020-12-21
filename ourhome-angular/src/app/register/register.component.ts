import {Component} from '@angular/core';
import {Router} from '@angular/router';
import {NgForm} from '@angular/forms';
import {UsersService} from '../service/users.service';
import {AuthService} from '../service/authentication/auth.service';
import {TokenStorageService} from '../service/authentication/token-storage.service';
import {MatStepper} from '@angular/material/stepper';

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

  profilePicture;

  onFileChange(event): void {
    this.profilePicture = event.target.files[0];
  }

  goForwardFirst(stepper: MatStepper, data: NgForm): void {
    this.usersService.getUserByEmail(data.value.email).subscribe(resp => {
      if (resp == null) {
        stepper.next();
      } else {
        alert('El email ya se ha registrado');
      }
    });
  }

  onSubmit(data: NgForm): void {
    this.usersService.getUserByEmail(data.value.email).subscribe(resp => {
      if (resp == null) {

        const formData = new FormData();

        formData.append('user', new Blob([JSON.stringify(data.value)], {type: 'application/json'}));
        if (this.profilePicture !== undefined) {
          formData.append('profilePicture', this.profilePicture);
        }

        this.usersService.createUsers(formData).subscribe(resp1 => {
          this.tokenStorageService.saveUser(resp1);

          this.authService.login({email: data.value.email, password: data.value.password}).subscribe(resp2 => {
            this.tokenStorageService.saveToken(resp2.headers.get('Authorization'));

            this.router.navigate(['initial-test']);
          });
        });
      } else {
        alert('El email ya se ha registrado');
      }
    });
  }
}
