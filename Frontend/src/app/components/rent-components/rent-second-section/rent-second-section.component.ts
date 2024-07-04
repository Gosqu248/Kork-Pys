import {Component, OnInit} from '@angular/core';
import {NgForOf} from "@angular/common";
import {RentGalleryItemComponent} from "../rent-gallery-item/rent-gallery-item.component";
import {ImageService} from "../../../services/image.service";

@Component({
  selector: 'app-rent-second-section',
  standalone: true,
  imports: [
    NgForOf,
    RentGalleryItemComponent
  ],
  providers: [ImageService],
  templateUrl: './rent-second-section.component.html',
  styleUrl: './rent-second-section.component.css'
})
export class RentSecondSectionComponent implements OnInit{
  public images: any;

  constructor(private ImageService: ImageService) {
  }

  ngOnInit(): void {
    console.log('Eco Gallery');
    this.fetchData();
  }

  fetchData(): void {
    this.ImageService.getCategoryImages('rent').subscribe({
      next: (images) => this.images = images,
      error: (err) => console.error('Failed to fetch eco images', err)
    });
  }
}
