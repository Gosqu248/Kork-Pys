import {Component, OnInit} from '@angular/core';
import {NgForOf} from "@angular/common";
import {ServiceItemComponent} from "../service-item/service-item.component";

@Component({
  selector: 'app-eco-services',
  standalone: true,
    imports: [
        ServiceItemComponent,
        NgForOf
    ],
  templateUrl: './eco-services.component.html',
  styleUrl: './eco-services.component.css'
})
export class EcoServicesComponent  implements OnInit{
  public services: any;

  constructor() {
  }

  ngOnInit(): void {
    console.log('HomeRentComponent initialized');
    this.fetchData();
  }

  fetchData(): void {
    this.services = [
      { title: 'Wywóz płynnych nieczystości', description: 'Opis usługi wywozu płynnych nieczystości.', image: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTUENscPbGJ-VPONgBqOeyAJ0X5GrmzFdzeAg&s' },
      { title: 'Opróżnianie przydomowych oczyszczalni', description: 'Opis usługi opróżniania przydomowych oczyszczalni.', image: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTUENscPbGJ-VPONgBqOeyAJ0X5GrmzFdzeAg&s' },
      { title: 'Wywóz szamba', description: 'Opis usługi wywozu szamba.', image: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTUENscPbGJ-VPONgBqOeyAJ0X5GrmzFdzeAg&s' }
    ];
  }

}
