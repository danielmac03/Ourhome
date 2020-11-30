import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class HomesService {

  private baseUrl = 'http://localhost:8181/api/homes';

  constructor(private http: HttpClient) { }

  getHomes(): Observable<any> {
    return this.http.get(`${this.baseUrl}/public/`);
  }

  getActiveHomes(): Observable<any> {
    return this.http.get(`${this.baseUrl}/public/active/`);
  }

  getHomesById(homeId: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/public/${homeId}`);
  }

  getHomesByUser(userId: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/user/${userId}`);
  }

  getHomesByCity(city: string): Observable<any> {
    return this.http.get(`${this.baseUrl}/city/${city}`);
  }

  createHomes(homes: object): Observable<object> {
    return this.http.post(`${this.baseUrl}`, homes);
  }

  updateHomes(homeId: number, value: any): Observable<object> {
    return this.http.put(`${this.baseUrl}/${homeId}`, value);
  }

  deleteHomes(homeId: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${homeId}`, { responseType: 'text' });
  }

}
