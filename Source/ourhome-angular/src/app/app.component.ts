import { Component, OnInit } from '@angular/core';
import { Router } from "@angular/router"
import { TokenStorageService } from './service/authentication/token-storage.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'OURHOME';

  constructor(private tokenStorageService: TokenStorageService, private router: Router) {}

  role = "";

  ngOnInit() {
    this.role = this.tokenStorageService.getUser().role;
  }

  logout() {
    this.tokenStorageService.signOut();
    this.router.navigate(['home']);
  }

}
