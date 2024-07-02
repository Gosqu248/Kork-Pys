import {Component, Input} from '@angular/core';

@Component({
  selector: 'app-construction-equipment-image',
  standalone: true,
  imports: [],
  templateUrl: './construction-equipment-image.component.html',
  styleUrl: './construction-equipment-image.component.css'
})
export class ConstructionEquipmentImageComponent {
  @Input() image?: string = '';

}
