import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { users } from '../model/users';
import { UsersService } from '../service/users.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css', '../app.component.css']
})
export class ProfileComponent implements OnInit {

  users: users;
  submitted = false;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private profileComponent: ProfileComponent,
    private usersService: UsersService
  ) {}


  ngOnInit() {
    this.users = new users();

    this.usersService.getUserById(this.route.snapshot.params['id']).subscribe(
      (data) => {
        this.users = data;
      },
      (error) => {
        this.router.navigate(['home']);
      }
    );
  }

  /*
    save(){
      this.usersService
      .createUsers(this.users).subscribe(data => {
        console.log(data);
        this.users = new users();
        this.router.navigate(['home']);
      },
      error => console.log(error));
    }

  onSubmit(){
    this.submitted = true;
    this.save();
  }*/

}
