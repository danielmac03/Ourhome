import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class HomesService {

  private baseUrl = 'http://localhost:8181/api/homes';

  constructor(private http: HttpClient) { }

  getHomes(home_id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${home_id}`);
  }

  createHomes(homes: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, homes);
  }

  updateHomes(home_id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${home_id}`, value);
  }

  deleteHomes(home_id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${home_id}`, { responseType: 'text' });
  }

  getHomesList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}
