import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class ProcessesService {

  private baseUrl = 'http://localhost:8181/api/processes';

  constructor(private http: HttpClient) { }

  getProcesses(process_id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${process_id}`);
  }

  createProcesses(processes: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, processes);
  }

  updateProcesses(process_id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${process_id}`, value);
  }

  deleteProcesses(process_id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${process_id}`, { responseType: 'text' });
  }

  getProcessesList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}
