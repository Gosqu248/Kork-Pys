import { Routes } from '@angular/router';
import {HomeComponent} from "./components/home/home.component";
import {authGuard} from "./services/auth.guard";
import path from "node:path";

export const routes: Routes = [
  {
    path: '',
    component: HomeComponent
  },
  {
    path: 'usługi-budowlane',
    loadComponent: () => import('./components/build-components/home-build/home-build.component').then(m => m.HomeBuildComponent)
  },
  // Wypożyczalnia sprzętu
  {
    path: 'wypożyczalnia-sprzętu',
    loadComponent: () => import('./components/rent-components/home-rent/home-rent.component').then(m => m.HomeRentComponent)
  },
  // HDS
  {
    path: 'usługi-hds',
    loadComponent: () => import('./components/hds-components/home-hds/home-hds.component').then(m => m.HomeHdsComponent)
  },

  {
    path: 'usługi-asenizacyjne',
    loadComponent: () => import('./components/eco-components/home-eco/home-eco.component').then(m => m.HomeEcoComponent)
  },

  {
    path: 'logowanie',
    loadComponent: () => import('./components/login-components/home-login/home-login.component').then(m => m.HomeLoginComponent)
  },

  {
    path: 'zalogowany',
    loadComponent: () => import('./components/login-components/home-customer/home-customer.component').then(m => m.HomeCustomerComponent),
    canActivate: [authGuard]
  },

  {
    path: 'resetowanie-hasła',
    loadComponent: () => import('./components/login-components/home-reset-password/home-reset-password.component').then(m => m.HomeResetPasswordComponent)
  },

  {
    path: 'reset-password',
    loadComponent: () => import('./components/login-components/reset-password/reset-password.component').then(m => m.ResetPasswordComponent)
  }
];
