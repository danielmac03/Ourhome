import {Component} from '@angular/core';
import {Router} from '@angular/router';
import {NgForm} from '@angular/forms';
import {UsersService} from '../service/users.service';
import {AuthService} from '../service/authentication/auth.service';
import {TokenStorageService} from '../service/authentication/token-storage.service';

@Component({
  selector: 'app-initial-test',
  templateUrl: './initial-test.component.html',
  styleUrls: ['./initial-test.component.css']
})
export class InitialTestComponent {

  constructor(
    private usersService: UsersService,
    private authService: AuthService,
    private router: Router,
    private tokenStorageService: TokenStorageService
  ) {
  }

  onSubmit(data: NgForm): void {
    const user = this.tokenStorageService.getUser();
    user.defaultTestResponses = JSON.stringify(data.value);

    const formData = new FormData();
    formData.append('user', new Blob([JSON.stringify(user)], {type: 'application/json'}));

    this.usersService.updateUser(formData).subscribe(resp => {
      this.tokenStorageService.saveUser(resp);

      this.router.navigate(['home']);
    });
  }
}
