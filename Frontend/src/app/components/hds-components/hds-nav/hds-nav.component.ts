import { Component } from '@angular/core';
import {ViewportScroller} from "@angular/common";

@Component({
  selector: 'app-hds-nav',
  standalone: true,
  imports: [],
  templateUrl: './hds-nav.component.html',
  styleUrl: './hds-nav.component.css'
})
export class HdsNavComponent {
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
