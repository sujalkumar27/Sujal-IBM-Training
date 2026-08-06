import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import {
  FormGroup,
  FormControl,
  Validators,
  ReactiveFormsModule
} from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [ReactiveFormsModule, CommonModule],
  templateUrl: 'login.html'
})
export class LoginComponent {
  accountNumber = '1234567890';

  loginForm = new FormGroup({
    username: new FormControl('user', [Validators.required]),
    password: new FormControl('user', [Validators.required])
  });

  error = '';

  constructor(private authService: AuthService, private router: Router) {}

  login() {
    const { username, password } = this.loginForm.value;
    if (this.authService.login(username || '', password || '')) {
      this.error = '';
      this.router.navigate(['/dashboard']);
    } else {
      this.error = 'Invalid credentials. Use user / user.';
    }
  }
}