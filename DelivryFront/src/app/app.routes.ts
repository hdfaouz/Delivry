import { Routes } from '@angular/router';
import {NavbarComponent} from "./navbar/navbar.component";
import {LoginComponent} from "./login/login.component";
import {HomeComponent} from "./home/home.component";
import {RegisterComponent} from "./register/register.component";

export const routes: Routes = [
  {path:"",component:RegisterComponent},
  {path:"login",component:LoginComponent},
];
