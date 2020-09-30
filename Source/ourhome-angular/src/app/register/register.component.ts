import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { users } from '../model/users';
import { UsersService } from '../service/users.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css', '../app.component.css']
})
export class RegisterComponent implements OnInit {

  name: string;
  surnames: string;
  age: number;
  email: string;
  phone: number;
  password: string;
  role: number;
  showPhone: number;

  constructor(private usersService: UsersService, private router: Router) { }

  ngOnInit() {
  }

  register() {
    let user = {name: this.name, surnames: this.surnames, age: this.age, email: this.email, password: this.password, role: this.role, showPhone: this.showPhone};

    this.usersService.getUserByEmail(this.email).subscribe(
      resp => {
        if(resp == null){
          this.usersService.createUsers(user).subscribe(data => {
            this.router.navigate(['home']);
          });
        }else{
          alert("El email ya existe");
        }
      },
    );
  }

}
