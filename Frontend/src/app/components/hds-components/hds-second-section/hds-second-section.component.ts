import {Component, OnInit} from '@angular/core';
import {EcoGalleryItemComponent} from "../../eco-components/eco-gallery-item/eco-gallery-item.component";
import {NgForOf} from "@angular/common";
import {HdsGalleryItemComponent} from "../hds-gallery-item/hds-gallery-item.component";
import {ImageService} from "../../../services/image.service";

@Component({
  selector: 'app-hds-second-section',
  standalone: true,
  imports: [
    EcoGalleryItemComponent,
    NgForOf,
    HdsGalleryItemComponent
  ],
  providers: [ImageService],
  templateUrl: './hds-second-section.component.html',
  styleUrl: './hds-second-section.component.css'
})
export class HdsSecondSectionComponent implements OnInit{
  public images: any;

  constructor(private ImageService: ImageService) {
  }

  ngOnInit(): void {
    console.log('Eco Gallery');
    this.fetchData();
  }

  fetchData(): void {
    this.ImageService.getCategoryImages('hds').subscribe({
      next: (images) => this.images = images,
      error: (err) => console.error('Failed to fetch hds images', err)
    });
  }
}
