import {Component, Input} from '@angular/core';
import {Router} from "@angular/router";
import {AuthService} from "../../../services/auth.service";
import {FormsModule} from "@angular/forms";

@Component({
  selector: 'app-customer-welcome',
  standalone: true,
  imports: [
    FormsModule
  ],
  templateUrl: './customer-welcome.component.html',
  styleUrl: './customer-welcome.component.css'
})
export class CustomerWelcomeComponent {


  @Input() customerName: string | undefined = undefined;

  constructor(private authService: AuthService, private router: Router) {}

  logout(): void {
    this.authService.logout();
    this.router.navigate(['/logowanie'])
  }

}
