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

  file;

  onFileChange(event): void {
    this.file = event.target.files[0];
  }

  onSubmit(data: NgForm): void {
    this.usersService.getUserByEmail(data.value.email).subscribe(resp => {
      if (resp == null) {
        const formData = new FormData();
        formData.append('profilePicture', this.file);
        formData.append('user', new Blob([JSON.stringify(data.value)], {type: 'application/json'}));

        this.usersService.createUsers(formData).subscribe(resp1 => {
          this.tokenStorageService.saveUser(resp1);

          this.authService.login({email: data.value.email, password: data.value.password}).subscribe(resp2 => {
            this.tokenStorageService.saveToken(resp2.headers.get('Authorization'));

            this.router.navigate(['initial-test']);
          }, error => {
            console.log('Error...');
          });
        });
      } else {
        alert('El email ya se ha registrado');
      }
    });
  }
}
