import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class CustomTestsService {

  private baseUrl = 'http://localhost:8181/api/customTests';

  constructor(private http: HttpClient) { }

  getCustomTests(custom_test_id : number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${custom_test_id }`);
  }

  createCustomTests(customTests: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, customTests);
  }

  updateCustomTests(custom_test_id : number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${custom_test_id }`, value);
  }

  deleteCustomTests(custom_test_id : number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${custom_test_id }`, { responseType: 'text' });
  }

  getCustomTestsList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}
