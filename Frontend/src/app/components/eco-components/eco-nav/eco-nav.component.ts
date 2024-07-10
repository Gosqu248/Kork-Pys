import { Component } from '@angular/core';
import {ViewportScroller} from "@angular/common";

@Component({
  selector: 'app-eco-nav',
  standalone: true,
  imports: [],
  templateUrl: './eco-nav.component.html',
  styleUrl: './eco-nav.component.css'
})
export class EcoNavComponent {
  constructor(private viewportScroller: ViewportScroller) { }
  scrollToElement(elementId: string): void {
    this.viewportScroller.scrollToAnchor(elementId);
  }

  toggleMenu() {
    const navMenu = document.getElementById('nav-menu');
    const nav = document.getElementById('nav');
    if (navMenu && nav) {
      navMenu.classList.toggle('expanded');
      nav.classList.toggle('nav-expanded');
    }
  }

}
