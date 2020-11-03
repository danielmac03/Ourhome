import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TokenStorageService } from '../service/authentication/token-storage.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css', '.././app.component.css']
})
export class HeaderComponent implements OnInit {

  user;
  city: string;

  constructor(
    private router: Router,
    private tokenStorageService: TokenStorageService
  ) {
    this.tokenStorageService.getStatusSaveUser().subscribe(status => {
      this.user = this.tokenStorageService.getUser();
    });
  }

  ngOnInit(): void {
    this.user = this.tokenStorageService.getUser();
  }

  searchByCity(): void {
    this.router.navigate(['home', this.city]);
  }

  logout(): void {
    this.tokenStorageService.signOut();
    this.router.navigate(['home']);
  }

}
