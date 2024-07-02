import {Component, Input} from '@angular/core';
import {ServiceImageComponent} from "../../eco-components/service-image/service-image.component";

@Component({
  selector: 'app-hds-item',
  standalone: true,
  imports: [
    ServiceImageComponent
  ],
  templateUrl: './hds-item.component.html',
  styleUrl: './hds-item.component.css'
})
export class HdsItemComponent {
  @Input() title?: string;
  @Input() description?: string;
  @Input() image?: string;

  constructor() {
  }
}
