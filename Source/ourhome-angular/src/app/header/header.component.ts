import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TokenStorageService } from '../service/authentication/token-storage.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css', '.././app.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private tokenStorageService: TokenStorageService, private router: Router) {}

  id = '';
  role = '';
  city: string;

  ngOnInit(): void {
    const user = this.tokenStorageService.getUser();

    if (user != null){
      this.role = user.role;
      this.id = user.id;
    }
  }

  searchByCity(): void {
    this.router.navigate(['home', this.city]);
  }

  logout(): void {
    this.tokenStorageService.signOut();
    this.router.navigate(['home']);
  }

}
