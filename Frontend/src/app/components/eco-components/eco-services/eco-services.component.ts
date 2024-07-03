import {Component, OnInit} from '@angular/core';
import {NgForOf} from "@angular/common";
import {ServiceItemComponent} from "../service-item/service-item.component";
import {ConstructionEquipmentService} from "../../../services/construction-equipment.service";
import {EcoServicesService} from "../../../services/eco-services.service";

@Component({
  selector: 'app-eco-services',
  standalone: true,
  imports: [
        ServiceItemComponent,
        NgForOf
    ],
  providers: [EcoServicesService],
  templateUrl: './eco-services.component.html',
  styleUrl: './eco-services.component.css'
})
export class EcoServicesComponent  implements OnInit{
  public ecoServices: any;

  constructor(private EcoServicesService: EcoServicesService) {
  }

  ngOnInit(): void {
    console.log('HomeRentComponent initialized');
    this.fetchData();
  }

  fetchData(): void {
    this.EcoServicesService.getEcoServices().subscribe(data => {
      this.ecoServices = data;
    });
  }

}
