import {Component, ElementRef, Input, ViewChild} from '@angular/core';

@Component({
  selector: 'app-rent-gallery-item',
  standalone: true,
  imports: [],
  templateUrl: './rent-gallery-item.component.html',
  styleUrl: './rent-gallery-item.component.css'
})
export class RentGalleryItemComponent {
  @Input() image?: string;
  @ViewChild('imageContainer') imageContainer!: ElementRef;

  constructor() {}

  openFullScreen(): void {
    if (this.imageContainer.nativeElement.requestFullscreen) {
      this.imageContainer.nativeElement.requestFullscreen();
    } else if (this.imageContainer.nativeElement.webkitRequestFullscreen) { /* Safari */
      this.imageContainer.nativeElement.webkitRequestFullscreen();
    } else if (this.imageContainer.nativeElement.msRequestFullscreen) { /* IE11 */
      this.imageContainer.nativeElement.msRequestFullscreen();
    }
  }
}
