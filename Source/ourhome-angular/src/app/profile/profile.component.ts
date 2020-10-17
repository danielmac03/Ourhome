import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TokenStorageService } from '../service/authentication/token-storage.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css', '../app.component.css']
})

export class ProfileComponent implements OnInit {

  constructor(private tokenStorageService: TokenStorageService, private route: ActivatedRoute, private router: Router) {}

  user = {} as any;

  ngOnInit() {
    this.user = this.tokenStorageService.getUser();
  }
}
