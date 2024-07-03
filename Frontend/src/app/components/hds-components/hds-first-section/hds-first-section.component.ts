import {Component, OnInit} from '@angular/core';

import {NgForOf} from "@angular/common";
import {HdsItemComponent} from "../hds-item/hds-item.component";
import {HdsServicesService} from "../../../services/hds-services.service";

@Component({
  selector: 'app-hds-first-section',
  standalone: true,
  imports: [
    NgForOf,
    HdsItemComponent
  ],
  templateUrl: './hds-first-section.component.html',
  styleUrl: './hds-first-section.component.css'
})
export class HdsFirstSectionComponent implements OnInit{
  public services: any;

  constructor(private HdsServiceService: HdsServicesService) {
  }

  ngOnInit(): void {
    console.log('HDS initialized');
    this.fetchData();
  }

  fetchData(): void {
    this.HdsServiceService.getHdsServices().subscribe(data => {
      this.services = data;
    })
  }
}
