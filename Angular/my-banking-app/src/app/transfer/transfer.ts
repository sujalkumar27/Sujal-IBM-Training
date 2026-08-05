import { Component } from '@angular/core';
import {
  ReactiveFormsModule,
  FormGroup,
  FormControl,
  Validators,
  FormArray
} from '@angular/forms';

import { CommonModule } from '@angular/common';

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
    ]),

    beneficiaries:new FormArray([

      new FormControl('')

    ])

  });

  constructor(

    private transferService:FundTransferService,

    private notificationService:NotificationService

  ){}


  get beneficiaries(){

    return this.transferForm.get('beneficiaries') as FormArray;

  }

  addBeneficiary(){

    this.beneficiaries.push(

      new FormControl('')

    );

  }

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