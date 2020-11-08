import { Component, OnInit } from '@angular/core';
import { TokenStorageService } from '../service/authentication/token-storage.service';
import { UsersService } from '../service/users.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  user;

  constructor(
    private tokenStorageService: TokenStorageService,
    private usersService: UsersService
  ) { }

  ngOnInit(): void {
    this.user = this.tokenStorageService.getUser();
  }

  onSubmit(form): void{
    this.user = Object.assign(this.user, form.value);

    this.usersService.updateUser(this.user).subscribe(resp => {
      this.tokenStorageService.saveUser(resp);
    }, error => {
      console.log('Error...');
    });
  }

}
