import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class CasasService {

  private baseUrl = 'http://localhost:8181/api/casas';

  constructor(private http: HttpClient) { }

  getCasas(id_casa: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id_casa}`);
  }

  createCasas(casas: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, casas);
  }

  updateCasas(id_casa: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id_casa}`, value);
  }

  deleteCasas(id_casa: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id_casa}`, { responseType: 'text' });
  }

  getCasasList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}
