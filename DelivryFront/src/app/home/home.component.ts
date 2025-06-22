import { Component } from '@angular/core';
import {HttpClientModule} from "@angular/common/http";
import {MatIcon} from "@angular/material/icon";
import {MatCard} from "@angular/material/card";
import {MatToolbar} from "@angular/material/toolbar";
import {MatButton} from "@angular/material/button";
import {RouterLink} from "@angular/router";

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [HttpClientModule, MatIcon, MatCard, MatToolbar, MatButton, RouterLink,],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {

}
