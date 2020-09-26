import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class TestPersonalizadosService {

  private baseUrl = 'http://localhost:8181/api/testsPersonalizados';

  constructor(private http: HttpClient) { }

  getTestPersonalizados(id_respuestas_test_personalizado : number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id_respuestas_test_personalizado }`);
  }

  createTestPersonalizados(testPersonalizados: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, testPersonalizados);
  }

  updateTestPersonalizados(id_respuestas_test_personalizado : number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id_respuestas_test_personalizado }`, value);
  }

  deleteTestPersonalizados(id_respuestas_test_personalizado : number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id_respuestas_test_personalizado }`, { responseType: 'text' });
  }

  getTestPersonalizadosList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}
