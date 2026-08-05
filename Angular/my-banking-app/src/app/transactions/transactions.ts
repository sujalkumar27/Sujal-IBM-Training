import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-transactions',
  standalone: true,
  imports: [CommonModule],

  template: `
    <h2>Transactions</h2>

    <table border="1" cellpadding="8">

      <tr>
        <th>Date</th>
        <th>Amount</th>
      </tr>

      <tr *ngFor="let txn of transactions">

        <td>{{txn.date}}</td>

        <td>{{txn.amount | currency:'INR'}}</td>

      </tr>

    </table>

    <p *ngIf="transactions.length==0">

      No Transactions Found

    </p>

  `
})
export class TransactionsComponent {

  transactions=[

    {
      date:'01-Aug-2026',
      amount:2500
    },

    {
      date:'02-Aug-2026',
      amount:-1000
    },

    {
      date:'03-Aug-2026',
      amount:500
    }

  ];

}