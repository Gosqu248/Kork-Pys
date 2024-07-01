import { Component } from '@angular/core';
import {NavbarComponent} from "../navbar-build/navbar.component";
import {BuildMainComponent} from "../build-main/build-main.component";
import {BuildAboutComponent} from "../build-about/build-about.component";
import {BuildServicesComponent} from "../build-services/build-services.component";
import {BuildGalleryComponent} from "../build-gallery/build-gallery.component";
import {BuildContactComponent} from "../build-contact/build-contact.component";

@Component({
  selector: 'app-home-build',
  standalone: true,
  imports: [
    NavbarComponent,
    BuildMainComponent,
    BuildAboutComponent,
    BuildServicesComponent,
    BuildGalleryComponent,
    BuildContactComponent
  ],
  templateUrl: './home-build.component.html',
  styleUrl: './home-build.component.css'
})
export class HomeBuildComponent {

}
