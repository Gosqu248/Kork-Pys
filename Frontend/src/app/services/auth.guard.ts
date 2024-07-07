import { CanActivateFn } from '@angular/router';
import {CustomersService} from "./customers.service";
import {inject} from "@angular/core";

export const authGuard: CanActivateFn = (route, state) => {

  const cusomersService = inject(CustomersService);
  return cusomersService.checkAuthenticationStatus()
};
