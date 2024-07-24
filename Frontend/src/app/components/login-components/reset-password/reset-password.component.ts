import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {AuthService} from "../../../services/auth.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-reset-password',
  standalone: true,
  templateUrl: './reset-password.component.html',
  imports: [
    ReactiveFormsModule
  ],
  styleUrl: './reset-password.component.css'
})
export class ResetPasswordComponent implements OnInit{

  resetForm: FormGroup;
  token: string | null = null;

  constructor(private authService: AuthService, private formBuilder: FormBuilder, private route: ActivatedRoute, private router: Router) {
    this.resetForm = this.formBuilder.group({
      newPassword: ['', [Validators.required, Validators.minLength(6)]],
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
      this.authService.confirmResetPassword(this.token, this.resetForm.value.newPassword).subscribe({
        next: () => {
          this.router.navigate(['/logowanie']);
        },
        error: (error) => {
          console.log('Reset password error: ', error);
        }
      });
    }
  }

}
