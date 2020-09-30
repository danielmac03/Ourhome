import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UsersService } from '../service/users.service';
import { AuthService } from "../service/authentication/auth.service";
import { TokenStorageService } from '../service/authentication/token-storage.service';

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

  constructor(private usersService: UsersService, private authService: AuthService, private tokenStorage: TokenStorageService, private router: Router) { }

  ngOnInit() {
  }

  register() {
    let user = {name: this.name, surnames: this.surnames, age: this.age, email: this.email, password: this.password, role: this.role, showPhone: this.showPhone};

    this.authService.login({email: "admin@ourhome.com", password: "password"}).subscribe(resp => {
      this.tokenStorage.saveToken(resp.headers.get("Authorization"));

      this.usersService.getUserByEmail(this.email).subscribe(resp1 => {
          if(resp1 == null){
            this.usersService.createUsers(user).subscribe(resp2 => {
              this.tokenStorage.saveUser(resp2);

              this.authService.login({email: this.email, password: this.password}).subscribe(resp3 => {
                this.tokenStorage.saveToken(resp3.headers.get("Authorization"));
              });

              this.router.navigate(['home']);
            });
          }else{
            alert("El email ya se ha registrado");
          }
        }
      );
    });
  }

}
