import { CanActivateFn } from '@angular/router';
import {AuthService} from "../services/auth.service";

export const authGuard: CanActivateFn = async (route, state) => {
  const authService: AuthService = new AuthService(); // Assuming AuthService is injectable, consider injecting it properly using Angular's DI system
  const isAuthenticated = await authService.isAuthenticated(); // Assuming `isAuthenticated` is an async method or has a way to be awaited
  if (!isAuthenticated) {
    // Optionally, redirect to login page
    // const router = new Router(); // This is just a placeholder, use Angular's DI to get the Router instance
    // router.navigate(['/login']);
    return false;
  }
  return true;
};
