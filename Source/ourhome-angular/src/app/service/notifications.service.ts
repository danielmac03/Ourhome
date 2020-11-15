import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class NotificationsService {

  private baseUrl = 'http://localhost:8181/api/notifications';

  constructor(private http: HttpClient) { }

  listNotifications(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

  listNotificationByHome(homeId: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/home/${homeId}`);
  }

  listNotificationByUser(userId: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/user/${userId}`);
  }

  getNotification(notificationId: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${notificationId}`);
  }

  createNotification(notification: object): Observable<object> {
    return this.http.post(`${this.baseUrl}`, notification);
  }

  updateNotifications(notificationId: number, value: any): Observable<object> {
    return this.http.put(`${this.baseUrl}/${notificationId}`, value);
  }

  deleteNotifications(notificationId: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${notificationId}`, { responseType: 'text' });
  }

}
