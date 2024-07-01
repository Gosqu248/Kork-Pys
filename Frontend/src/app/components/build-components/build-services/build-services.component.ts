import {Component, OnInit} from '@angular/core';
import AOS from 'aos';

@Component({
  selector: 'app-build-services',
  standalone: true,
  imports: [],
  templateUrl: './build-services.component.html',
  styleUrl: './build-services.component.css'
})
export class BuildServicesComponent implements OnInit{
  constructor() {
  }
  ngOnInit(): void {
    // Other initialization logic
  }
  ngAfterViewInit(): void {
    AOS.init();
  }
}
