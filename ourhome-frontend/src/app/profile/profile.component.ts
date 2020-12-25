import {Component, OnInit} from '@angular/core';
import {TokenStorageService} from '../service/token-storage.service';
import {UsersService} from '../service/users.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  user;
  profilePicture;
  profilePicturePreview;

  constructor(
    private tokenStorageService: TokenStorageService,
    private usersService: UsersService
  ) {
  }

  ngOnInit(): void {
    this.user = this.tokenStorageService.getUser();
  }

  onFileChange(event): void {
    this.profilePicture = null;
    this.profilePicturePreview = null;

    if (event.target.files[0].type.match(/image\/*/) !== null) {
      this.profilePicture = event.target.files[0];

      const reader = new FileReader();
      reader.readAsDataURL(event.target.files[0]);
      reader.onload = () => this.profilePicturePreview = reader.result;
    } else {
      alert('Solo debe subir imagenes');
    }
  }

  onSubmitUser(data): void {
    const userUpdated = Object.assign(this.user, data.value);

    const formData = new FormData();
    formData.append('user', new Blob([JSON.stringify(userUpdated)], {type: 'application/json'}));

    this.usersService.getUserByEmail(data.value.email).subscribe(resp1 => {
        if (resp1 == null || this.user.id === resp1.id) {
          this.usersService.updateUser(formData).subscribe(resp => {
            this.user = userUpdated;
            this.tokenStorageService.saveUser(resp);
          });
        } else {
          alert('El email ya se ha registrado');
        }
      }
    );
  }

  onSubmitProfilePicture(): void {
    const formData = new FormData();
    formData.append('profilePicture', this.profilePicture);
    formData.append('user', new Blob([JSON.stringify(this.user)], {type: 'application/json'}));

    this.usersService.updateUser(formData).subscribe(resp2 => {
      this.user = resp2;
      this.tokenStorageService.saveUser(resp2);
    });
  }
}
