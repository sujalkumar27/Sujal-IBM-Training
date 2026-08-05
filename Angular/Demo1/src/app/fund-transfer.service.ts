import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class FundTransferService {

  transferFunds(fromAccount: string, toAccount: string, amount: number): string {

    if (amount <= 0) {
      return 'Invalid transfer amount';
    }

    return `₹${amount} transferred from ${fromAccount} to ${toAccount}`;
  }

}