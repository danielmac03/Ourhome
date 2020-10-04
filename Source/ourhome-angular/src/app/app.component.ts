import { Component, OnInit } from '@angular/core';
import { TokenStorageService } from './service/authentication/token-storage.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'OURHOME';

  constructor(private tokenStorageService: TokenStorageService) {}

  role = "";

  ngOnInit() {

    this.role = this.tokenStorageService.getUser().role;

    console.log(this.tokenStorageService.getUser().email)
    console.log(this.tokenStorageService.getUser().role);

  }

}
