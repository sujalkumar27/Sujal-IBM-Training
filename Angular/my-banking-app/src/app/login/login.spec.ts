import { ComponentFixture, TestBed } from '@angular/core/testing';
import { LoginComponent } from './login';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { RouterTestingModule } from '@angular/router/testing';

class MockAuthService {
  login = jasmine.createSpy('login');
}

class MockRouter {
  navigate = jasmine.createSpy('navigate');
}

describe('LoginComponent', () => {
  let component: LoginComponent;
  let fixture: ComponentFixture<LoginComponent>;
  let authService: MockAuthService;
  let router: MockRouter;

  beforeEach(async () => {
    authService = new MockAuthService();
    router = new MockRouter();

    await TestBed.configureTestingModule({
      imports: [LoginComponent, ReactiveFormsModule, CommonModule, RouterTestingModule],
      providers: [
        { provide: AuthService, useValue: authService },
        { provide: Router, useValue: router }
      ]
    }).compileComponents();

    fixture = TestBed.createComponent(LoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create the component', () => {
    expect(component).toBeTruthy();
  });

  it('should have default form values', () => {
    expect(component.loginForm.value).toEqual({ username: 'user', password: 'user' });
  });

  it('should call authService.login and navigate on successful login', () => {
    authService.login.and.returnValue(true);
    component.login();

    expect(authService.login).toHaveBeenCalledWith('user', 'user');
    expect(component.error).toBe('');
    expect(router.navigate).toHaveBeenCalledWith(['/dashboard']);
  });

  it('should show error message on failed login', () => {
    authService.login.and.returnValue(false);
    component.login();

    expect(component.error).toBe('Invalid credentials. Use user / user.');
    expect(router.navigate).not.toHaveBeenCalled();
  });

  it('should require username and password', () => {
    component.loginForm.setValue({ username: '', password: '' });
    expect(component.loginForm.valid).toBeFalse();
  });
});
