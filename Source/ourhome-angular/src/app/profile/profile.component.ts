import {Component, OnInit} from '@angular/core';
import {TokenStorageService} from '../service/authentication/token-storage.service';
import {UsersService} from '../service/users.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  user;
  file;

  constructor(
    private tokenStorageService: TokenStorageService,
    private usersService: UsersService
  ) {
  }

  ngOnInit(): void {
    this.user = this.tokenStorageService.getUser();
  }

  onFileChange(event): void {
    this.file = event.target.files[0];
  }

  onSubmitProfilePicture(): void {
    const formData = new FormData();
    formData.append('profilePicture', this.file);
    formData.append('user', new Blob([JSON.stringify(this.user)], {type: 'application/json'}));

    this.usersService.updateProfilePicture(formData).subscribe(resp2 => {
      this.tokenStorageService.saveUser(resp2);
      this.user = resp2;
    }, error => {
      console.log('Error...');
    });
  }

  onSubmitUser(data): void {
    this.user = Object.assign(this.user, data.value);

    this.usersService.getUserByEmail(data.value.email).subscribe(resp1 => {
        if (resp1 == null || this.user.id === resp1.id) {
          this.usersService.updateUser(this.user).subscribe(resp => {
            this.tokenStorageService.saveUser(resp);
          }, error => {
            console.log('Error...');
          });
        } else {
          alert('El email ya se ha registrado');
        }
      }, error => {
        console.log('Error...');
      }
    );
  }
}
