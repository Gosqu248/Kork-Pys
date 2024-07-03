import {Component, OnInit} from '@angular/core';
import {EcoGalleryItemComponent} from "../eco-gallery-item/eco-gallery-item.component";
import {ImageService} from "../../../services/image.service";
import {NgForOf} from "@angular/common";

@Component({
  selector: 'app-eco-gallery',
  standalone: true,
  imports: [
    EcoGalleryItemComponent,
    NgForOf
  ],
  providers: [ImageService],
  templateUrl: './eco-gallery.component.html',
  styleUrl: './eco-gallery.component.css'
})
export class EcoGalleryComponent implements OnInit{
    public images: any;

    constructor(private ImageService: ImageService) {
    }

  ngOnInit(): void {
    console.log('Eco Gallery');
    this.fetchEcoImages();
  }

  fetchEcoImages(): void {
    this.ImageService.getImagesByCategory('eco').subscribe(images => {
      this.images = images;
    });
  }

  fetchData(): void {
    this.ImageService.getImages().subscribe(data => {
      this.images = data;
    });
  }
}
