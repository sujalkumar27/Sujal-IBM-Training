import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import {
  FormGroup,
  FormControl,
  FormArray,
  Validators,
  ReactiveFormsModule
} from '@angular/forms';

@Component({
  selector: 'app-transfer',
  standalone: true,
  imports: [ReactiveFormsModule, CommonModule],
  templateUrl: './transfer.component.html'
})
export class TransferComponent {

  transferForm = new FormGroup({
    fromAccount: new FormControl('', Validators.required),
    toAccount: new FormControl('', Validators.required),
    amount: new FormControl('', [
      Validators.required,
      Validators.min(100)
    ])
  });

  transfer() {
    console.log(this.transferForm.value);
  }
}