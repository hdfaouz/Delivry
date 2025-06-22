import {Component, Inject, OnInit} from '@angular/core';
import {RouterLink, RouterOutlet} from "@angular/router";
import {CommonModule, NgIf} from "@angular/common";
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatAnchor, MatButtonModule, MatIconButton} from "@angular/material/button";
import {HttpClientModule} from "@angular/common/http";
import {MatSidenavModule} from "@angular/material/sidenav";
import {MatIcon} from "@angular/material/icon";
import {MatMenu, MatMenuItem, MatMenuTrigger} from "@angular/material/menu";

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [
    RouterLink,
    CommonModule,
    MatToolbarModule,
    MatButtonModule,
    HttpClientModule,
    MatSidenavModule,
    MatToolbarModule,
    MatIcon,
    MatIconButton,
    MatAnchor,
    RouterOutlet,
    MatMenu,
    MatMenuTrigger,
    MatMenuItem,
    NgIf
  ],


  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})
export class NavbarComponent implements OnInit{

  ngOnInit(): void {
  }

}
