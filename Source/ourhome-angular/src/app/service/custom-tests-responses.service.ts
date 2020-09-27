import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class CustomTestsResponsesService {

  private baseUrl = 'http://localhost:8181/api/customTestResponses';

  constructor(private http: HttpClient) { }

  getCustomTestsResponses(custom_test_response_id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${custom_test_response_id}`);
  }

  createCustomTestsResponses(customTestResponses: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, customTestResponses);
  }

  updateCustomTestsResponses(custom_test_response_id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${custom_test_response_id}`, value);
  }

  deleteCustomTestsResponses(custom_test_response_id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${custom_test_response_id}`, { responseType: 'text' });
  }

  getCustomTestsResponsesList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}
