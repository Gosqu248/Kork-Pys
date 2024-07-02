import { Component } from '@angular/core';
import {
    ConstructionEquipmentItemComponent
} from "../../rent-components/construction-equipment-item/construction-equipment-item.component";
import {NgForOf} from "@angular/common";

@Component({
  selector: 'app-hds-first-section',
  standalone: true,
    imports: [
        ConstructionEquipmentItemComponent,
        NgForOf
    ],
  templateUrl: './hds-first-section.component.html',
  styleUrl: './hds-first-section.component.css'
})
export class HdsFirstSectionComponent {

}
