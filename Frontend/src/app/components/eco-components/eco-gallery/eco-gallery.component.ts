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
    this.fetchData();
  }

  fetchData(): void {
    this.ImageService.getCategoryImages('eco').subscribe({
      next: (images) => this.images = images,
      error: (err) => console.error('Failed to fetch eco images', err)
    });
  }
}
