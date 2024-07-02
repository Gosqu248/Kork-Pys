import {Component, OnInit} from '@angular/core';

import {NgForOf} from "@angular/common";
import {HdsItemComponent} from "../hds-item/hds-item.component";

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

  constructor() {
  }

  ngOnInit(): void {
    console.log('HDS initialized');
    this.fetchData();
  }

  fetchData(): void {
    this.services = [
      { title: 'Przewóz rzeczy wraz z załadunkiem', description: 'Opis usługi wywozu płynnych nieczystości.', image: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTUENscPbGJ-VPONgBqOeyAJ0X5GrmzFdzeAg&s' },
      { title: 'Usługi transportowe', description: 'Opis usługi opróżniania przydomowych oczyszczalni.', image: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTUENscPbGJ-VPONgBqOeyAJ0X5GrmzFdzeAg&s' },
      { title: 'Dostawa materiałów z wypożyczalni', description: 'Opis usługi wywozu szamba.', image: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTUENscPbGJ-VPONgBqOeyAJ0X5GrmzFdzeAg&s' }
    ];
  }
}
