import {ApplicationConfig, provideZoneChangeDetection} from '@angular/core';
import { provideRouter } from '@angular/router';

import { routes } from './app.routes';
// @ts-ignore
import {MatToolbarModule} from '@angular/material/toolbar';
import {provideAnimationsAsync} from "@angular/platform-browser/animations/async";
import {provideClientHydration} from "@angular/platform-browser";
// @ts-ignore
import {MatIconModule} from '@angular/material/icon';

export const appConfig: ApplicationConfig = {
  providers: [provideRouter(routes),provideZoneChangeDetection({ eventCoalescing: true }),
     provideClientHydration(),
    MatToolbarModule,
    MatIconModule,
    provideAnimationsAsync(), provideAnimationsAsync()]
};
