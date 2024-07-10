import { Component } from '@angular/core';
import {ViewportScroller} from "@angular/common";

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})
export class NavbarComponent {
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
