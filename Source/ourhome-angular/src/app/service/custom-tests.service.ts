import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class CustomTestsService {

  private baseUrl = 'http://localhost:8181/api/customTests';

  constructor(private http: HttpClient) { }

  getCustomTests(customTestId: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${customTestId}`);
  }

  getCustomTestsByUser(userId: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/user/${userId}`);
  }

  createCustomTests(customTests: object): Observable<object> {
    return this.http.post(`${this.baseUrl}`, customTests);
  }

  updateCustomTests(customTestId: number, value: any): Observable<object> {
    return this.http.put(`${this.baseUrl}/${customTestId}`, value);
  }

  deleteCustomTests(customTestId: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${customTestId}`, { responseType: 'text' });
  }

  getCustomTestsList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}
