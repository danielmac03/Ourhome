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

  constructor(
    private route: ActivatedRoute,
    private router: Router,
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

}
