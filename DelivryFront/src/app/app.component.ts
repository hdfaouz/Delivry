import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { NavbarComponent } from './navbar/navbar.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    RouterOutlet,
    LoginComponent,
    NavbarComponent,
    RegisterComponent,
    HomeComponent,
  ],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'] // ✅ PLURIEL
})
export class AppComponent {
  title = 'DelivryFront';
}
