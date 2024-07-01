import { Component } from '@angular/core';
import {ViewportScroller} from "@angular/common";

@Component({
  selector: 'app-rent-nav',
  standalone: true,
  imports: [],
  templateUrl: './rent-nav.component.html',
  styleUrl: './rent-nav.component.css'
})
export class RentNavComponent {
  constructor(private viewportScroller: ViewportScroller) { }
  scrollToElement(elementId: string): void {
  this.viewportScroller.scrollToAnchor(elementId);
}
}
