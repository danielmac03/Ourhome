import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class UsuariosService {

  private baseUrl = 'http://localhost:8181/api/usuarios';

  constructor(private http: HttpClient) { }

  getUsuarios(id_usuario: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id_usuario}`);
  }

  createUsuarios(usuarios: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, usuarios);
  }

  updateUsuarios(id_usuario: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id_usuario}`, value);
  }

  deleteUsuarios(id_usuario: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id_usuario}`, { responseType: 'text' });
  }

  getUsuariosList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}
