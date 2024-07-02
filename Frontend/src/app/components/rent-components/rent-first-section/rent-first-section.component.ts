import {Component, Input, OnInit,} from '@angular/core';
import {CommonModule} from "@angular/common";
import {ConstructionEquipmentService} from "../../../services/construction-equipment.service";
import {ConstructionEquipmentItemComponent} from "../construction-equipment-item/construction-equipment-item.component";

@Component({
  selector: 'app-rent-first-section',
  templateUrl: './rent-first-section.component.html',
  standalone: true,
  imports: [CommonModule, ConstructionEquipmentItemComponent],
  providers: [ConstructionEquipmentService],
  styleUrls: ['./rent-first-section.component.css']
})
export class RentFirstSectionComponent implements OnInit{
  public constructionEquipment: any;


  constructor(private constructionEquipmentService: ConstructionEquipmentService) {
  }

  ngOnInit(): void {
    console.log('HomeRentComponent initialized');
    this.fetchData();
  }

  fetchData(): void {
    this.constructionEquipmentService.getConstructionEquipment().subscribe(data => {
      this.constructionEquipment = data;
    });
  }

}
