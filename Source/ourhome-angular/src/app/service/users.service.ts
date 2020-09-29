import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UsersService {

  private baseUrl = 'http://localhost:8181/api/users';

  constructor(private http: HttpClient) { }

  getUserById(user_id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${user_id}`);
  }

  getUserByEmail(user_email: string): Observable<any> {
    return this.http.get(`${this.baseUrl}/email/${user_email}`);
  }

  createUsers(users: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, users);
  }

  updateUsers(user_id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${user_id}`, value);
  }

  deleteUsers(user_id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${user_id}`, { responseType: 'text' });
  }

  getUsersList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}
