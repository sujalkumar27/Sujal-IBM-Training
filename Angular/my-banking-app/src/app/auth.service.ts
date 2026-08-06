import { Injectable, signal } from '@angular/core';

@Injectable({ providedIn: 'root' })
export class AuthService {
  loggedIn = signal(false);

  login(username: string, password: string): boolean {
    if (username === 'user' && password === 'user') {
      this.loggedIn.set(true);
      return true;
    }
    return false;
  }

  logout() {
    this.loggedIn.set(false);
  }

  isLoggedIn(): boolean {
    return this.loggedIn();
  }
}
