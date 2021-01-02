import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {NotificationsService} from '../service/notifications.service';
import {TokenStorageService} from '../service/token-storage.service';
import * as $ from 'jquery';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  user;
  notifications;

  constructor(
    private router: Router,
    private notificationsService: NotificationsService,
    private tokenStorageService: TokenStorageService
  ) {
    this.tokenStorageService.getStatusSaveUser().subscribe(status => {
      this.user = this.tokenStorageService.getUser();
    });
  }

  ngOnInit(): void {
    this.user = this.tokenStorageService.getUser();

    if (this.user.id !== undefined){
      this.notificationsService.listNotificationByUser(this.user.id).subscribe(resp => {
        this.notifications = resp;
      });
    }
  }

  deleteNotification(notificationId: number, divId: string): void{
    $(divId).remove();

    this.notificationsService.deleteNotifications(notificationId).subscribe(resp => {
      console.log('Completed...');
    });
  }

  logout(): void {
    this.tokenStorageService.signOut();
    this.router.navigate(['home']);
  }

}
