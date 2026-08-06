import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import {
  ReactiveFormsModule,
  FormGroup,
  FormControl,
  Validators
} from '@angular/forms';

import { FundTransferService } from '../fund-transfer';
import { NotificationService } from '../notification';

@Component({
  selector: 'app-transfer',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    CommonModule
  ],
  templateUrl:'./transfer.html'
})
export class TransferComponent {

  message='';

  transferForm=new FormGroup({
    fromAccount:new FormControl('',Validators.required),
    toAccount:new FormControl('',Validators.required),
    amount:new FormControl('',[
      Validators.required,
      Validators.min(100)
    ])
  });

  get amountValue(): number {
    return Number(this.transferForm.controls.amount.value) || 0;
  }

  get balance(): number {
    return this.transferService.getBalance();
  }

  get insufficientFunds(): boolean {
    return this.amountValue > this.balance;
  }

  constructor(
    private transferService:FundTransferService,
    private notificationService:NotificationService
  ){}

  transfer(){
    const value=this.transferForm.value;
    this.message=this.transferService.transferFunds(
      value.fromAccount!,
      value.toAccount!,
      Number(value.amount)
    );
    this.notificationService.notifyUser(this.message);
  }
}
