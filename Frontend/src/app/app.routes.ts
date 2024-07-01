import { Routes } from '@angular/router';

export const routes: Routes = [
  {
    path: '',
    loadComponent: () => import('./components/home/home.component').then(m => m.HomeComponent)
  },
  {
    path: 'usługi-budowlane',
    loadComponent: () => import('./components/build-components/home-build/home-build.component').then(m => m.HomeBuildComponent)
  },
  {
    path: 'usługi-asenizacyjne',
    loadComponent: () => import('./components/eco-components/home-eco/home-eco.component').then(m => m.HomeEcoComponent)
  },

  // Wypożyczalnia sprzętu
  {
    path: 'wypożyczalnia-sprzętu',
    loadComponent: () => import('./components/rent-components/home-rent/home-rent.component').then(m => m.HomeRentComponent)
  },
  /*{
    path: 'wypożyczalnia-sprzętu/strona-glowna',
    loadComponent: () => import('./components/rent-components/rent-intro/rent-intro.component').then(m => m.RentIntroComponent)
  },
  {
    path: 'wypożyczalnia-sprzętu/wynajem',
    loadComponent: () => import('./components/rent-components/rent-first-section/rent-first-section.component').then(m => m.RentFirstSectionComponent)
  },
  {
    path: 'wypożyczalnia-sprzętu/galeria',
    loadComponent: () => import('./components/rent-components/rent-second-section/rent-second-section.component').then(m => m.RentSecondSectionComponent)
  },
  {
    path: 'wypożyczalnia-sprzętu/kontakt',
    loadComponent: () => import('./components/rent-components/rent-footer/rent-footer.component').then(m => m.RentFooterComponent)
  },*/
];
