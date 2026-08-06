import { Injectable } from '@angular/core';
import { NotificationService } from './notification';

export interface Transaction {
  date: string;
  amount: number;
  fromAccount: string;
  toAccount: string;
}

@Injectable({
  providedIn: 'root'
})
export class FundTransferService {
  private balance = 100000;
  private transactions: Transaction[] = [
    { date: '01-Aug-2026', amount: 2500, fromAccount: 'A1', toAccount: 'B1' },
    { date: '02-Aug-2026', amount: -1000, fromAccount: 'A1', toAccount: 'B2' },
    { date: '03-Aug-2026', amount: 500, fromAccount: 'A2', toAccount: 'B1' }
  ];

  constructor(private notificationService: NotificationService) {}

  getBalance(): number {
    return this.balance;
  }

  getTransactions(): Transaction[] {
    return this.transactions;
  }

  transferFunds(fromAccount: string, toAccount: string, amount: number): string {
    if (amount <= 0) {
      const invalidResult = 'Invalid transfer amount';
      this.notificationService.notifyUser(invalidResult);
      return invalidResult;
    }

    if (amount > this.balance) {
      const insufficientResult = 'Insufficient balance. Transfer cannot be completed.';
      this.notificationService.notifyUser(insufficientResult);
      return insufficientResult;
    }

    const result = `₹${amount} transferred from ${fromAccount} to ${toAccount}`;
    this.balance -= amount;
    this.transactions.unshift({
      date: new Date().toLocaleDateString('en-GB', {
        day: '2-digit',
        month: 'short',
        year: 'numeric'
      }),
      amount: -amount,
      fromAccount,
      toAccount
    });
    this.notificationService.notifyUser(result);
    return result;
  }
}
