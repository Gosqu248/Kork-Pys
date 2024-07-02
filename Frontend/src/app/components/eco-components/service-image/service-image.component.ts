import {Component, Input} from '@angular/core';

@Component({
  selector: 'app-service-image',
  standalone: true,
  imports: [],
  templateUrl: './service-image.component.html',
  styleUrl: './service-image.component.css'
})
export class ServiceImageComponent {
  @Input() image?: string;

}
