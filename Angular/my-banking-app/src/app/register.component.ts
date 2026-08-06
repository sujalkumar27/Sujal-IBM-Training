import { Component } from '@angular/core';
import { FormGroup, FormControl, Validators, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [ReactiveFormsModule],
  template: `
    <h2>Register</h2>
    <form [formGroup]="registerForm" (ngSubmit)="register()">
      <label>Username</label>
      <input formControlName="username" />
      <br /><br />
      <label>Password</label>
      <input type="password" formControlName="password" />
      <br /><br />
      <button type="submit">Register</button>
    </form>
  `
})
export class RegisterComponent {
  registerForm = new FormGroup({
    username: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required),
  });

  register() {
    console.log('Register data', this.registerForm.value);
  }
}
