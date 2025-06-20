  import { Component } from '@angular/core';
  import {RouterLink} from '@angular/router';
  import { RouterOutlet } from '@angular/router';
  import {MatSlideToggle} from '@angular/material/slide-toggle';
  import {navbar} from '../nav/nav.component'

  @Component({
    selector: 'app-root',
    standalone: true,
    imports: [RouterOutlet,MatSlideToggle, navbar]
    templateUrl: './app.component.html',
    styleUrl: './app.component.css'
  })
  export class AppComponent {
    title = 'DelivryFront';
  }
