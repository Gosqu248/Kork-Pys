import {Component, Input} from '@angular/core';

import {ServiceImageComponent} from "../service-image/service-image.component";

@Component({
  selector: 'app-service-item',
  standalone: true,
  imports: [
    ServiceImageComponent
  ],
  templateUrl: './service-item.component.html',
  styleUrl: './service-item.component.css'
})
export class ServiceItemComponent {
  @Input() title?: string;
  @Input() description?: string;
  @Input() image?: string;

  constructor() {
  }
}
