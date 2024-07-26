import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {AuthService} from "../../../services/auth.service";
import {ActivatedRoute, Router} from "@angular/router";
import {NgIf} from "@angular/common";

@Component({
  selector: 'app-reset-password',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    NgIf
  ],
  templateUrl: './reset-password.component.html',
  styleUrl: './reset-password.component.css'
})
export class ResetPasswordComponent implements OnInit{

  resetForm: FormGroup;
  token: string | null = null;

  constructor(private authService: AuthService, private formBuilder: FormBuilder, private route: ActivatedRoute, private router: Router) {
    this.resetForm = this.formBuilder.group({
      newPassword: ['', [Validators.required, Validators.minLength(6)]],
      confirmPassword: ['', Validators.required]
    });
  }

  ngOnInit() {
    this.route.queryParams.subscribe(params => {
      this.token = params['token'];
      console.log('Token: ', this.token);
    });
  }

  onSubmit() {
    if(this.resetForm.valid) {

      const newPassword = this.resetForm.value.newPassword;
      const confirmPassword = this.resetForm.value.confirmPassword;

      if (newPassword !== confirmPassword) {
        alert('Hasła nie pasują do siebie!.');
        return;
      }

      this.authService.confirmResetPassword(this.token, newPassword).subscribe({
        next: () => {
          this.router.navigate(['/logowanie']);
        },
        error: (error) => {
          alert('Hasła nie pasują do siebie!.');
        }
      });
    }
  }

  hasMinLengthError() {
    const newPasswordControl = this.resetForm.get('newPassword');
    return newPasswordControl?.touched && newPasswordControl?.hasError('minlength');
  }

}
