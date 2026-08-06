import { Component } from '@angular/core';
import { CommonModule, CurrencyPipe } from '@angular/common';
import { FormGroup, FormControl, Validators, ReactiveFormsModule } from '@angular/forms';
import { FundTransferService } from '../fund-transfer';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, CurrencyPipe],
  template: `
    <div class="summary-row">
      <div class="summary-card">
        <h2>Welcome back</h2>
        <p class="subheading">Hello Narendra Modi, here is your current account overview.</p>
      </div>
      <div class="summary-card">
        <p class="section-title">Available Balance</p>
        <p class="balance-value">{{ balance | currency:'INR' }}</p>
      </div>
    </div>

    <div class="card transfer-card">
      <div class="section-header">
        <h3>Fund Transfer</h3>
        <p class="subheading">Move money between accounts quickly and securely.</p>
      </div>

      <form [formGroup]="transferForm" (ngSubmit)="transfer()" class="form-grid">
        <div class="field">
          <label>From Account</label>
          <input formControlName="fromAccount" placeholder="Enter from account" />
        </div>

        <div class="field">
          <label>To Account</label>
          <input formControlName="toAccount" placeholder="Enter to account" />
        </div>

        <div class="field">
          <label>Amount</label>
          <input type="number" formControlName="amount" placeholder="Enter amount" />
          <div *ngIf="transferForm.controls.amount.errors?.['min']" class="error">
            Minimum transfer amount is ₹100.
          </div>
          <div *ngIf="transferForm.controls.amount.valid && insufficientFunds" class="error">
            Insufficient balance for this transfer.
          </div>
        </div>

        <button type="submit" class="btn btn-primary" [disabled]="transferForm.invalid || insufficientFunds">Transfer</button>
      </form>

      <div *ngIf="message" class="note">{{ message }}</div>
    </div>
  `
})
export class DashboardComponent {
  transferForm = new FormGroup({
    fromAccount: new FormControl('', Validators.required),
    toAccount: new FormControl('', Validators.required),
    amount: new FormControl('', [Validators.required, Validators.min(100)])
  });

  balance = 0;
  message = '';

  constructor(private transferService: FundTransferService) {
    this.balance = this.transferService.getBalance();
  }

  get amountValue(): number {
    return Number(this.transferForm.controls.amount.value) || 0;
  }

  get insufficientFunds(): boolean {
    return this.amountValue > this.balance;
  }

  transfer() {
    const { fromAccount, toAccount, amount } = this.transferForm.value;
    const result = this.transferService.transferFunds(
      fromAccount || '',
      toAccount || '',
      Number(amount)
    );
    this.message = result;
    this.balance = this.transferService.getBalance();
  }
}
