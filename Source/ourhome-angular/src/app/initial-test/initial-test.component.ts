import { Component } from '@angular/core';
import { UsersService } from '../service/users.service';
import { TokenStorageService } from '../service/authentication/token-storage.service';

@Component({
  selector: 'app-initial-test',
  templateUrl: './initial-test.component.html',
  styleUrls: ['./initial-test.component.css', '../app.component.css']
})
export class InitialTestComponent {

  p1: string;
  p2: string;
  p3: string;
  p4: string;
  p5: string;

  constructor(private usersService: UsersService, private tokenStorageService: TokenStorageService) { }

  save(){
    let answer = this.p1.toString() + this.p2.toString() + this.p3.toString() + this.p4.toString() + this.p5.toString();

    var user = this.tokenStorageService.getUser();
    user.defaultTestResponses = answer;

    console.log(user)

    this.usersService.updateUsers(user.id, user).subscribe(
      resp =>{
        console.log("jklj")
      }
    );

  }

}
