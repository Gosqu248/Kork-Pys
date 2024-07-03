import {Component, Input} from '@angular/core';

@Component({
  selector: 'app-eco-gallery-item',
  standalone: true,
  imports: [],
  templateUrl: './eco-gallery-item.component.html',
  styleUrl: './eco-gallery-item.component.css'
})
export class EcoGalleryItemComponent {
  @Input() image?: string;
  constructor() {
  }
}
