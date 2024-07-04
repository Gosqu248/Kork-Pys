import { Component } from '@angular/core';
import {BuildAboutComponent} from "../../build-components/build-about/build-about.component";
import {BuildContactComponent} from "../../build-components/build-contact/build-contact.component";
import {BuildGalleryComponent} from "../../build-components/build-gallery/build-gallery.component";
import {BuildHeaderComponent} from "../../build-components/build-header/build-header.component";
import {BuildMainComponent} from "../../build-components/build-main/build-main.component";
import {BuildServicesComponent} from "../../build-components/build-services/build-services.component";
import {NavbarComponent} from "../../build-components/navbar-build/navbar.component";
import {EcoContactComponent} from "../eco-contact/eco-contact.component";
import {EcoHeaderComponent} from "../eco-header/eco-header.component";
import {EcoNavComponent} from "../eco-nav/eco-nav.component";
import {EcoIntroComponent} from "../eco-intro/eco-intro.component";
import {EcoServicesComponent} from "../eco-services/eco-services.component";
import {EcoGalleryComponent} from "../eco-gallery/eco-gallery.component";
import {EcoLoginComponent} from "../eco-login/eco-login.component";

@Component({
  selector: 'app-home-eco',
  standalone: true,
  imports: [
    BuildAboutComponent,
    BuildContactComponent,
    BuildGalleryComponent,
    BuildHeaderComponent,
    BuildMainComponent,
    BuildServicesComponent,
    NavbarComponent,
    EcoContactComponent,
    EcoHeaderComponent,
    EcoNavComponent,
    EcoIntroComponent,
    EcoServicesComponent,
    EcoGalleryComponent,
    EcoLoginComponent,
  ],
  templateUrl: './home-eco.component.html',
  styleUrl: './home-eco.component.css'
})
export class HomeEcoComponent {

}
