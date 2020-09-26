import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class ProcesosService {

  private baseUrl = 'http://localhost:8181/api/procesos';

  constructor(private http: HttpClient) { }

  getProcesos(id_proceso: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id_proceso}`);
  }

  createProcesos(procesos: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, procesos);
  }

  updateProcesos(id_proceso: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id_proceso}`, value);
  }

  deleteProcesos(id_proceso: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id_proceso}`, { responseType: 'text' });
  }

  getProcesosList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}
