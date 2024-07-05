import {Component, OnInit} from '@angular/core';
import {EcoContactComponent} from "../../eco-components/eco-contact/eco-contact.component";
import {EcoGalleryComponent} from "../../eco-components/eco-gallery/eco-gallery.component";
import {EcoHeaderComponent} from "../../eco-components/eco-header/eco-header.component";
import {EcoIntroComponent} from "../../eco-components/eco-intro/eco-intro.component";
import {EcoLoginComponent} from "../../eco-components/eco-login/eco-login.component";
import {EcoNavComponent} from "../../eco-components/eco-nav/eco-nav.component";
import {EcoServicesComponent} from "../../eco-components/eco-services/eco-services.component";
import {LoginMainComponent} from "../login-main/login-main.component";
import {ComarchApiService} from "../../../services/comarch-api.service";


@Component({
  selector: 'app-home-login',
  standalone: true,
  imports: [
    LoginMainComponent
  ],
  templateUrl: './home-login.component.html',
  styleUrl: './home-login.component.css'
})
export class HomeLoginComponent {

}
