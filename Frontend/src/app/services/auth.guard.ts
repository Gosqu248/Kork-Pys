import { CanActivateFn } from '@angular/router';
import { AuthService } from "./auth.service";
import { inject } from "@angular/core";
import { map } from 'rxjs/operators';
import { Router } from '@angular/router';

export const authGuard: CanActivateFn = (route, state) => {
  const authService = inject(AuthService);
  const router = inject(Router);
  return authService.checkAuthenticationStatus().pipe(
    map(isAuthenticated => {
      if (!isAuthenticated) {
        router.navigate(['/logowanie']);
        return false;
      }
      return true;
    })
  );
};
