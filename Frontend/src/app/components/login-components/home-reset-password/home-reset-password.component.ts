import { Component } from '@angular/core';
import {LoginMainComponent} from "../login-main/login-main.component";
import {FaIconComponent} from "@fortawesome/angular-fontawesome";
import {FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators} from "@angular/forms";
import {Router, RouterLink} from "@angular/router";
import {AuthService} from "../../../services/auth.service";

@Component({
  selector: 'app-home-reset-password',
  standalone: true,
  imports: [
    LoginMainComponent,
    FaIconComponent,
    FormsModule,
    ReactiveFormsModule,
    RouterLink
  ],
  templateUrl: './home-reset-password.component.html',
  styleUrl: './home-reset-password.component.css'
})
export class HomeResetPasswordComponent {
  resetPasswordForm: FormGroup;

  constructor(private authService: AuthService, private formBuilder: FormBuilder, private router: Router) {
    this.resetPasswordForm = this.formBuilder.group({
      email: ['', [Validators.required, Validators.email]]
    });
  }

  onSubmit(): void {
    if (this.resetPasswordForm.valid) {
      this.authService.resetPassword(this.resetPasswordForm.value.email).subscribe({
        next: () => {
          this.router.navigate(['/logowanie']);
        },
        error: (error) => {
          console.log('Error resetting password: ', error);
        }
      });
    }
  }

}
