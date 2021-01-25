import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {FormControl, FormGroup, FormGroupDirective, Validators} from '@angular/forms';
import {UsersService} from '../service/users.service';
import {TokenStorageService} from '../service/token-storage.service';

declare var $: any;

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  form;

  constructor(
    private router: Router,
    private usersService: UsersService,
    private tokenStorageService: TokenStorageService
  ) {
  }

  ngOnInit(): void {
    this.form = new FormGroup({
      email: new FormControl('', [Validators.required, Validators.email]),
      password: new FormControl('', [Validators.required])
    });
  }

  onSubmit(data: FormGroupDirective): void {
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
