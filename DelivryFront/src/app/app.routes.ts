import { Routes } from '@angular/router';

import {LoginComponent} from "./login/login.component";
import {RegisterComponent} from "./register/register.component";
import {HomeComponent} from "./home/home.component";
import {AnnonceComponent} from "./annonce/annonce.component";



export const routes: Routes = [
  {path:"",component:LoginComponent},
  {path:"register",component:RegisterComponent},
  {path:"login",component:LoginComponent},
  {path:"home",component:HomeComponent},
  {path:"annonce",component:AnnonceComponent}


];
