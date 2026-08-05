import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private _isAuthenticated = false;

  login(username: string, password: string): boolean {
    if (username === 'user' && password === 'user') {
      this._isAuthenticated = true;
      return true;
    }
    this._isAuthenticated = false;
    return false;
  }

  logout(): void {
    this._isAuthenticated = false;
  }

  isLoggedIn(): boolean {
    return this._isAuthenticated;
  }
}
