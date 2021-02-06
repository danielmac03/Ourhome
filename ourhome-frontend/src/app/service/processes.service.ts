import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class ProcessesService {

  private baseUrl = 'http://localhost:8181/api/processes';

  constructor(private http: HttpClient) {
  }

  listProcesses(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

  listProcessByHome(homeId: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/home/${homeId}`);
  }

  listProcessByUser(userId: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/user/${userId}`);
  }

  existProcess(homeId: number, userId: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${homeId}/${userId}`);
  }

  getProcess(processId: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${processId}`);
  }

  createProcess(process: object): Observable<object> {
    return this.http.post(`${this.baseUrl}`, process);
  }

  deleteProcesses(processId: number, role: string): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${processId}/${role}`, {responseType: 'text'});
  }

  deleteProcessesByHome(userId: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/home/${userId}`, {responseType: 'text'});
  }

}
