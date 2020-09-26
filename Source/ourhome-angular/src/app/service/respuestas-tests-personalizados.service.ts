import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class RespuestasTestsPersonalizadosService {

  private baseUrl = 'http://localhost:8181/api/respuestasTestsPersonalizados';

  constructor(private http: HttpClient) { }

  getRespuestasTestsPersonalizados(id_respuestas_test_personalizado: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id_respuestas_test_personalizado}`);
  }

  createRespuestasTestsPersonalizados(respuestasTestsPersonalizados: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, respuestasTestsPersonalizados);
  }

  updateRespuestasTestsPersonalizados(id_respuestas_test_personalizado: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id_respuestas_test_personalizado}`, value);
  }

  deleteRespuestasTestsPersonalizados(id_respuestas_test_personalizado: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id_respuestas_test_personalizado}`, { responseType: 'text' });
  }

  getRespuestasTestsPersonalizadosList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}
