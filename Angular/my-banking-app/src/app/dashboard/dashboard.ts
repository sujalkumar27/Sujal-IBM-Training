import { Component } from '@angular/core';
import { CurrencyPipe } from '@angular/common';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [CurrencyPipe],
  template: `
    <h2>Dashboard</h2>

    <p><strong>Account Holder:</strong> John Doe</p>

    <p>
      <strong>Available Balance:</strong>
      {{ balance | currency:'INR' }}
    </p>
  `
})
export class DashboardComponent {

  balance = 5000;

}