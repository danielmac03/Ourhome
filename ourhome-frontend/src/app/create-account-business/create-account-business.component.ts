import {Component} from '@angular/core';
import {Router} from '@angular/router';
import {NgForm} from '@angular/forms';
import {MatStepper} from '@angular/material/stepper';
import {UsersService} from '../service/users.service';
import {TokenStorageService} from '../service/token-storage.service';

@Component({
  selector: 'app-register-business',
  templateUrl: './create-account-business.component.html',
  styleUrls: ['./create-account-business.component.css']
})
export class CreateAccountBusinessComponent {

  constructor(
    private router: Router,
    private usersService: UsersService,
    private tokenStorageService: TokenStorageService
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

        data.value.role = 'business';

        const formData = new FormData();

        formData.append('user', new Blob([JSON.stringify(data.value)], {type: 'application/json'}));
        if (this.profilePicture !== undefined) {
          formData.append('profilePicture', this.profilePicture);
        }

        this.usersService.createUsers(formData).subscribe(resp1 => {
          this.tokenStorageService.saveUser(resp1);

          this.usersService.getAuthorization({
            email: data.value.email,
            password: data.value.password
          }).subscribe(resp2 => {
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
