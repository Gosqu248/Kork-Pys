import { Component } from '@angular/core';
import {RentFirstSectionComponent} from "../../rent-components/rent-first-section/rent-first-section.component";
import {RentFooterComponent} from "../../rent-components/rent-contact/rent-footer.component";
import {RentHeaderComponent} from "../../rent-components/rent-header/rent-header.component";
import {RentIntroComponent} from "../../rent-components/rent-intro/rent-intro.component";
import {RentNavComponent} from "../../rent-components/rent-nav/rent-nav.component";
import {RentSecondSectionComponent} from "../../rent-components/rent-gallery/rent-second-section.component";
import {HdsHeaderComponent} from "../hds-header/hds-header.component";
import {HdsNavComponent} from "../hds-nav/hds-nav.component";
import {HdsIntroComponent} from "../hds-intro/hds-intro.component";
import {HdsFirstSectionComponent} from "../hds-first-section/hds-first-section.component";
import {HdsSecondSectionComponent} from "../hds-gallery/hds-second-section.component";
import {HdsFooterComponent} from "../hds-contact/hds-footer.component";

@Component({
  selector: 'app-home-hds',
  standalone: true,
  imports: [
    RentFirstSectionComponent,
    RentFooterComponent,
    RentHeaderComponent,
    RentIntroComponent,
    RentNavComponent,
    RentSecondSectionComponent,
    HdsHeaderComponent,
    HdsNavComponent,
    HdsIntroComponent,
    HdsFirstSectionComponent,
    HdsSecondSectionComponent,
    HdsFooterComponent
  ],
  templateUrl: './home-hds.component.html',
  styleUrl: './home-hds.component.css'
})
export class HomeHdsComponent {

}
