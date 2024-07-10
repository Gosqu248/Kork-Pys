import { Component } from '@angular/core';
import {RentHeaderComponent} from "../rent-header/rent-header.component";
import {RentNavComponent} from "../rent-nav/rent-nav.component";
import {RentFooterComponent} from "../rent-contact/rent-footer.component";
import {RentIntroComponent} from "../rent-intro/rent-intro.component";
import {RentFirstSectionComponent} from "../rent-first-section/rent-first-section.component";
import {RentSecondSectionComponent} from "../rent-gallery/rent-second-section.component";

@Component({
  selector: 'app-home-rent',
  standalone: true,
  imports: [
    RentHeaderComponent,
    RentNavComponent,
    RentFooterComponent,
    RentIntroComponent,
    RentSecondSectionComponent,
    RentFirstSectionComponent,

  ],
  templateUrl: './home-rent.component.html',
  styleUrl: './home-rent.component.css'
})
export class HomeRentComponent {

}
