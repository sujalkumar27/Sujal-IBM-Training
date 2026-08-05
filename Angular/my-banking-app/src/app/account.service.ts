import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { delay } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AccountService {

  checkAccount(account: string): Observable<boolean> {

    const accounts = ['1001', '1002', '1003'];

    return of(accounts.includes(account)).pipe(
      delay(2000)
    );
  }

}