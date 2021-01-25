import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {FormControl, FormGroup, FormGroupDirective, Validators} from '@angular/forms';
import {UsersService} from '../service/users.service';
import {TokenStorageService} from '../service/token-storage.service';
import {ExistEmailDirective} from '../directives/exist-email.directive';

@Component({
  selector: 'app-register',
  templateUrl: './create-account.component.html',
  styleUrls: ['./create-account.component.css']
})
export class CreateAccountComponent implements OnInit {

  form;
  profilePicture;
  createPersonalAccount = true;

  constructor(
    private router: Router,
    private usersService: UsersService,
    private tokenStorageService: TokenStorageService,
    private existEmailValidateDirectiveDirective: ExistEmailDirective
  ) {
  }

  ngOnInit(): void {
    this.form = new FormGroup({
      email: new FormControl('', [Validators.required, Validators.email], [this.existEmailValidateDirectiveDirective.validate(false)]),
      password: new FormControl('', [Validators.required]),
      description: new FormControl('', [Validators.required]),
      birthdate: new FormControl(''),
      phone: new FormControl(''),
      showPhone: new FormControl(''),
      acceptPolicy: new FormControl('', [Validators.requiredTrue])
    });

    if (this.router.url === '/create-account') {
      this.form.addControl('name', new FormControl('', [Validators.required]));
      this.form.addControl('surnames', new FormControl('', [Validators.required]));
      this.form.addControl('role', new FormControl('', [Validators.required]));
    } else {
      this.form.addControl('company', new FormControl('', [Validators.required]));
      this.createPersonalAccount = false;
    }
  }

  onFileChange(event): void {
    this.profilePicture = event.target.files[0];
  }

  onSubmit(data: FormGroupDirective): void {
    if (this.createPersonalAccount) {
      if (data.value.role === '0') {
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

        if (data.value.role === 'business') {
          this.router.navigate(['home']);
        } else {
          this.router.navigate(['initial-test']);
        }
      });
    });
  }
}
