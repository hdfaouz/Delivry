import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { Router } from '@angular/router';

// Angular Material modules
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';

import { AuthService } from '../auth.service';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,  // <-- important
    MatFormFieldModule,
    MatInputModule,
    MatIconModule,
    MatButtonModule,
    MatCardModule,
    MatProgressSpinnerModule,
  ],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  FormLogin: FormGroup;
  loading = false;
  error = '';
  successMsg = '';

  constructor(
    private formBuilder: FormBuilder,
    private authService: AuthService,
    private router: Router
  ) {
    this.FormLogin = this.formBuilder.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required],
    });
  }

  ngOnInit(): void {
    this.error = '';
    this.successMsg = '';
  }

  get email() {
    return this.FormLogin.get('email');
  }

  get password() {
    return this.FormLogin.get('password');
  }

  onSubmit(): void {
    this.error = '';
    this.successMsg = '';
    this.loading = true;

    if (this.FormLogin.valid) {
      const dataLogin = this.FormLogin.value;

      this.authService.login(dataLogin).subscribe({
        next: (response) => {
          localStorage.setItem('token', response.token);
          localStorage.setItem('role', response.role);

          if (response.role.toLowerCase() === 'admin') {
            alert('Bienvenue admin');
            // this.router.navigate(['/admin-dashboard']);
          } else {
            alert('Bienvenue utilisateur');
            // this.router.navigate(['/user-dashboard']);
          }

          this.loading = false;
        },
        error: (err) => {
          this.error = err?.error?.message || 'Échec de la connexion';
          this.loading = false;
        }
      });
    } else {
      this.loading = false;
      this.error = 'Veuillez remplir correctement le formulaire.';
    }
  }
}
