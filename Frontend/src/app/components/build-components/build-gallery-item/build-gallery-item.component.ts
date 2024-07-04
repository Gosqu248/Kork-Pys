import {Component, ElementRef, Input, ViewChild} from '@angular/core';

@Component({
  selector: 'app-build-gallery-item',
  standalone: true,
  imports: [],
  templateUrl: './build-gallery-item.component.html',
  styleUrl: './build-gallery-item.component.css'
})
export class BuildGalleryItemComponent {
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
