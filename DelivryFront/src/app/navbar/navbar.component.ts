import { Component } from '@angular/core';
import {RouterLink, RouterOutlet} from '@angular/router';
// @ts-ignore
import {MatToolbarModule} from '@angular/material/toolbar';
// @ts-ignore
import {MatIcon} from '@angular/material/icon';
// @ts-ignore
import {MatAnchor, MatIconButton} from '@angular/material/button';
// @ts-ignore
import {MatSidenavModule} from '@angular/material/sidenav';

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [ MatSidenavModule,
    RouterLink,
    MatToolbarModule,
    MatIcon,
    MatIconButton,
    MatAnchor,
    RouterOutlet],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})
export class NavbarComponent {


}
