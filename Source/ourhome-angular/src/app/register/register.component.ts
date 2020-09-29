import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { users } from '../model/users';
import { UsersService } from '../service/users.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css', '../app.component.css']
})
export class RegisterComponent implements OnInit {

  users: users = new users();
  submitted = false;

  constructor(private usersService: UsersService, private router: Router) { }

  ngOnInit() {
  }

  newUser() :  void {
    this.submitted  = false;
    this.users = new users();
  }

  save() {
    this.usersService
    .createUsers(this.users).subscribe(data => {
      console.log(data)
      this.users = new users();
      this.gotoList();
    },
    error => console.log(error));
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }

  gotoList() {
    this.router.navigate(['/employees']);
  }

}
