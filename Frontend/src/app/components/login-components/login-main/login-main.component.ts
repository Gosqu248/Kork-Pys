import {Component, OnInit} from '@angular/core';
import {CustomersService} from "../../../services/customers.service";
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

  constructor(private customerService: CustomersService, private router: Router) { }

  onSubmit() {
  this.customerService.authenticateUser(this.street, this.buildingNumber).subscribe((isAuthenticated: boolean) => {
    if (isAuthenticated) {
      this.router.navigate(['/zalogowany']);
    } else {
      console.log(this.street)
      console.log(this.buildingNumber)
      alert('Nieprawidłowy login lub hasło!');
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
