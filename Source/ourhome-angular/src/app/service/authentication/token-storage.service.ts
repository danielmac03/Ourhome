import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

const TOKEN_KEY = 'auth-token';
const USER_KEY = 'auth-user';

@Injectable({
  providedIn: 'root'
})
export class TokenStorageService {

  private statusSaveUser: Subject<boolean> = new Subject();

  constructor() { }

  public getStatusSaveUser(): Subject<boolean> {
    return this.statusSaveUser;
  }

  public signOut(): void {
    window.sessionStorage.clear();
  }

  public saveToken(token: string): void {
    window.sessionStorage.setItem(TOKEN_KEY, token);
  }

  public getToken(): string {
    return sessionStorage.getItem(TOKEN_KEY);
  }

  public saveUser(user): void {
    window.sessionStorage.setItem(USER_KEY, JSON.stringify(user));
    this.statusSaveUser.next(true);
  }

  public getUser() {
    return JSON.parse(sessionStorage.getItem(USER_KEY));
  }
}
