import {AfterViewInit, Component, OnInit} from '@angular/core';
import AOS from 'aos';

@Component({
  selector: 'app-build-about',
  standalone: true,
  imports: [],
  templateUrl: './build-about.component.html',
  styleUrl: './build-about.component.css'
})
export class BuildAboutComponent implements OnInit, AfterViewInit {

  constructor() {
  }
  ngOnInit(): void {
    // Other initialization logic
  }
  ngAfterViewInit(): void {
    AOS.init();
  }
}

