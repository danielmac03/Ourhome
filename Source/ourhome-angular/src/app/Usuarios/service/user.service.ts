import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class UserService {

  private baseUrl = 'http://localhost:8181/api/usuarios';

  constructor (private http: HttpClient) {}

  listarUsuarios(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

}
