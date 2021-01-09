import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RecoveryPasswordService {

  private baseUrl = 'http://localhost:8181/api/recovery-passwords';

  constructor(private http: HttpClient) {
  }

  forgotPassword(email: string): Observable<any> {
    return this.http.post(`${this.baseUrl}/public/forgot/`, email);
  }

  isValid(token: object): Observable<any> {
    return this.http.post(`${this.baseUrl}/public/isValid/`, token);
  }

  recoveryPassword(recovery: object): Observable<any> {
    return this.http.post(`${this.baseUrl}/public/recovery/`, recovery);
  }
}
