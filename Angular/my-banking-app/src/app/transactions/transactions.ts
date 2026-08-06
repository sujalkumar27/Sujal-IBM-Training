import { Component } from '@angular/core';
import { CommonModule, CurrencyPipe } from '@angular/common';
import { FundTransferService, Transaction } from '../fund-transfer';

@Component({
  selector: 'app-transactions',
  standalone: true,
  imports: [CommonModule, CurrencyPipe],
  template: `
    <div class="card">
      <div class="section-header">
        <h2>Transactions</h2>
        <p class="subheading">Recent transfers are displayed below.</p>
      </div>

      <div class="table-card">
        <table class="transactions-table">
          <thead>
            <tr>
              <th>Date</th>
              <th>From</th>
              <th>To</th>
              <th>Amount</th>
            </tr>
          </thead>
          <tbody>
            <tr *ngFor="let txn of transactions">
              <td>{{ txn.date }}</td>
              <td>{{ txn.fromAccount }}</td>
              <td>{{ txn.toAccount }}</td>
              <td>{{ txn.amount | currency:'INR' }}</td>
            </tr>
          </tbody>
        </table>
      </div>

      <p *ngIf="transactions.length === 0" class="note">
        No Transactions Found
      </p>
    </div>
  `
})
export class TransactionsComponent {
  transactions: Transaction[] = [];

  constructor(private transferService: FundTransferService) {
    this.transactions = this.transferService.getTransactions();
  }
}
