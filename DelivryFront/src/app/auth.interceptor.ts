import {HttpHandlerFn, HttpInterceptorFn, HttpRequest} from '@angular/common/http';
import {AuthService} from "./Services/auth.service";
import {inject} from "@angular/core";

export const authInterceptor: HttpInterceptorFn = (req: HttpRequest<unknown>, next: HttpHandlerFn) => {
  const authService = inject(AuthService);

  if (req.url.includes('/api/v1/auth/') || !authService.getToken()) {
    return next(req);
  }

  const authReq = req.clone({
    setHeaders: {
      Authorization: `Bearer ${authService.getToken()}`
    }
  });

  return next(authReq);
};
