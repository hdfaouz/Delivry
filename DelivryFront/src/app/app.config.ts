import {ApplicationConfig, importProvidersFrom, provideZoneChangeDetection} from '@angular/core';
import { provideRouter } from '@angular/router';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import { HttpClientModule } from '@angular/common/http';
import {routes} from "./app.routes";
import {MatIconModule} from "@angular/material/icon";
import {MatCardModule} from "@angular/material/card";
import {MatButtonModule} from "@angular/material/button";
import {MatToolbarModule} from "@angular/material/toolbar";
import {provideNativeDateAdapter} from "@angular/material/core";


export const appConfig: ApplicationConfig = {
  providers: [
    provideRouter(routes),
    provideAnimationsAsync(),
    importProvidersFrom(HttpClientModule),
    importProvidersFrom(MatToolbarModule),
    importProvidersFrom(MatButtonModule),
    importProvidersFrom(MatCardModule),
    importProvidersFrom(MatIconModule),
    provideNativeDateAdapter()
  ]
};
