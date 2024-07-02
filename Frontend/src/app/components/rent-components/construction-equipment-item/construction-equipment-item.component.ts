import {Component, Input} from '@angular/core';
import {
  ConstructionEquipmentImageComponent
} from "../construction-equipment-image/construction-equipment-image.component";

@Component({
  selector: 'app-construction-equipment-item',
  standalone: true,
  imports: [
    ConstructionEquipmentImageComponent
  ],
  templateUrl: './construction-equipment-item.component.html',
  styleUrl: './construction-equipment-item.component.css'
})
export class ConstructionEquipmentItemComponent {
  @Input() title?: string;
  @Input() description?: string;
  @Input() image?: string;

  constructor() {
  }
}
