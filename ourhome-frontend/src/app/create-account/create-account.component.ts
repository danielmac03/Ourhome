import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {NgForm} from '@angular/forms';
import {MatStepper} from '@angular/material/stepper';
import {UsersService} from '../service/users.service';
import {TokenStorageService} from '../service/token-storage.service';

@Component({
  selector: 'app-register',
  templateUrl: './create-account.component.html',
  styleUrls: ['./create-account.component.css']
})
export class CreateAccountComponent implements OnInit {

  constructor(
    private router: Router,
    private usersService: UsersService,
    private tokenStorageService: TokenStorageService
  ) {
  }

  createPersonalAccount = true;
  profilePicture;

  ngOnInit(): void {
    if (this.router.url === '/create-account-business') {
      this.createPersonalAccount = false;
    }
  }

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

        if (this.createPersonalAccount) {
          if (data.value.role === 0) {
            data.value.role = 'search';
            data.value.remainingPublications = 0;
          } else {
            data.value.role = 'have';
            data.value.remainingPublications = 1;
          }
        } else {
          data.value.role = 'business';
          data.value.remainingPublications = 5;
        }

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
