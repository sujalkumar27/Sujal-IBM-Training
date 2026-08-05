import { Component } from '@angular/core';
import { FundTransferService } from './fund-transfer.service';
import { NotificationService } from './notification.service';

@Component({
  selector: 'app-transfer',
  standalone: true,

  template: `
    <h2>Fund Transfer</h2>

    <button (click)="doTransfer()">
      Transfer ₹500
    </button>

    <p>{{message}}</p>
  `
})

export class TransferComponent {

  message = '';

  constructor(
    private transferService: FundTransferService,
    private notificationService: NotificationService
  ) {}

  doTransfer() {

    this.message = this.transferService.transferFunds(
      'Account A',
      'Account B',
      500
    );

    this.notificationService.notifyUser(this.message);

  }

}