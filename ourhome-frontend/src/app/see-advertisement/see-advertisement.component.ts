import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {DomSanitizer} from '@angular/platform-browser';
import {HomesService} from '../service/homes.service';
import {ProcessesService} from '../service/processes.service';
import {TokenStorageService} from '../service/token-storage.service';

@Component({
  selector: 'app-see-advertisement',
  templateUrl: './see-advertisement.component.html',
  styleUrls: ['./see-advertisement.component.css'],
})
export class SeeAdvertisementComponent implements OnInit {

  home = {
    id: undefined,
    photos: undefined,
    direction: undefined,
    characteristics: undefined
  };
  user;
  existProcess;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private domSanitizer: DomSanitizer,
    private homesService: HomesService,
    private processesService: ProcessesService,
    private tokenStorageService: TokenStorageService
  ) {
  }

  ngOnInit(): void {
    this.user = this.tokenStorageService.getUser();

    this.homesService.getHomeById(this.route.snapshot.params.home).subscribe(resp => {
      this.home = resp;
      this.home.characteristics = JSON.parse(this.home.characteristics);
      this.home.direction = this.domSanitizer.bypassSecurityTrustResourceUrl('https://www.google.com/maps/embed/v1/place?key=AIzaSyB4pHuIU5cQEqWeJCz_Gfcf84YiMhpmaXw&q=' + this.home.direction.replace(' ', '+'));
    });

    this.processesService.existProcess(this.route.snapshot.params.home, this.user.id).subscribe(resp1 => {
      this.existProcess = resp1;
    });
  }

  contact(): void {
    this.router.navigate(['custom-test', this.home.id]);
  }
}
