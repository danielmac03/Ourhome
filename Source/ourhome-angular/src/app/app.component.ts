import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { TokenStorageService } from './service/authentication/token-storage.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'OURHOME';

  constructor(private tokenStorageService: TokenStorageService, private router: Router) {}

  role = '';
  city: string;

  ngOnInit() {
    const user = this.tokenStorageService.getUser();

    if (user != null){
      this.role = user.role;
    }
  }

  searchByCity() {
    this.router.navigate(['home', this.city]);
  }

  logout() {
    this.tokenStorageService.signOut();
    this.router.navigate(['home']);
  }
}
