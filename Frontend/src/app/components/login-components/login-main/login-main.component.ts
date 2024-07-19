import { Component } from '@angular/core';
import { AuthService } from "../../../services/auth.service"; // Import AuthService
import { faChevronDown, faChevronUp } from '@fortawesome/free-solid-svg-icons';
import { FaIconComponent } from "@fortawesome/angular-fontawesome";
import { Router } from '@angular/router';
import { FormsModule } from "@angular/forms";

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
export class LoginMainComponent {

  login: string = '';
  password: string = '';

  constructor(private authService: AuthService, private router: Router) { } // Use AuthService

  onSubmit() {
    this.authService.login(this.login, this.password).subscribe((isAuthenticated: boolean) => {
      if (isAuthenticated) {
        this.router.navigate(['/zalogowany']);
      } else {
        console.log(this.login)
        console.log(this.password)
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
