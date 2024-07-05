import {Component, OnInit} from '@angular/core';
import {ComarchApiService} from "../../../services/comarch-api.service";
import { faChevronDown, faChevronUp } from '@fortawesome/free-solid-svg-icons';
import {FaIconComponent} from "@fortawesome/angular-fontawesome";
import { Router } from '@angular/router';
import {FormsModule} from "@angular/forms";

@Component({
  selector: 'app-login-main',
  standalone: true,
  imports: [
    FaIconComponent,
    FormsModule
  ],
  templateUrl: './login-main.component.html',
  styleUrl: './login-main.component.css'
})
export class LoginMainComponent  {


  street: string = '';
  buildingNumber: string = '';

  constructor(private comarchApiService: ComarchApiService, private router: Router) { }

  onSubmit() {
    this.comarchApiService.authenticateUser(this.street, this.buildingNumber).subscribe(isAuthenticated => {
      if (isAuthenticated) {
        // Navigate to the dashboard or home page
        this.router.navigate(['/zalogowany']);
      } else {
        console.log(this.street)
        console.log(this.buildingNumber)
        alert('Authentication failed. Please check your credentials.');
      }
    });
  }

  isExpanded = false;
  faChevronDown = faChevronDown;
  faChevronUp = faChevronUp;

  toggle() {
    this.isExpanded = !this.isExpanded;
  }


}
