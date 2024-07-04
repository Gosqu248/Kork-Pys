import { Component, OnInit } from '@angular/core';
import {NgForOf} from "@angular/common";
import {BuildGalleryItemComponent} from "../build-gallery-item/build-gallery-item.component";
import {ImageService} from "../../../services/image.service";

@Component({
  selector: 'app-build-gallery',
  standalone: true,
  imports: [
    NgForOf,
    BuildGalleryItemComponent
  ],
  providers: [ImageService],
  templateUrl: './build-gallery.component.html',
  styleUrl: './build-gallery.component.css'
})
export class BuildGalleryComponent implements OnInit {
  public images: any;

  constructor(private ImageService: ImageService) {
  }

  ngOnInit(): void {
    console.log('Build Gallery');
    this.fetchData();
  }

  fetchData(): void {
    this.ImageService.getCategoryImages('build').subscribe({
      next: (images) => this.images = images,
      error: (err) => console.error('Failed to fetch eco images', err)
    });
  }
}
