import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class CustomTestsResponsesService {

  private baseUrl = 'http://localhost:8181/api/customTestResponses';

  constructor(private http: HttpClient) { }

  getCustomTestsResponses(customTestResponseId: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${customTestResponseId}`);
  }

  createCustomTestsResponses(customTestResponses: object): Observable<object> {
    return this.http.post(`${this.baseUrl}`, customTestResponses);
  }

  updateCustomTestsResponses(customTestResponseId: number, value: any): Observable<object> {
    return this.http.put(`${this.baseUrl}/${customTestResponseId}`, value);
  }

  deleteCustomTestsResponses(customTestResponseId: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${customTestResponseId}`, { responseType: 'text' });
  }

  getCustomTestsResponsesList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}
