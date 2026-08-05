import { Component } from '@angular/core';
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
  imports: [ReactiveFormsModule],
  templateUrl: './login.html'
})

export class LoginComponent {
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
