import {Component} from '@angular/core';
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {CustomersService} from "../../../services/customers.service";
import {NgIf} from "@angular/common";
import { jwtDecode } from "jwt-decode";
import {ChangePasswordResponse} from "../../../interfaces/change-password-response";


@Component({
  selector: 'app-change-password',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    NgIf
  ],
  templateUrl: './change-password.component.html',
  styleUrl: './change-password.component.css'
})
export class ChangePasswordComponent{

  changeForm: FormGroup;


  constructor(private formBuilder: FormBuilder, private customerService: CustomersService, private router: Router) {
    this.changeForm = this.formBuilder.group( {
      currentPassword: ['', Validators.required],
      newPassword: ['', [Validators.required, Validators.minLength(6)]],
    });
  }



  onChangePassword() {
    if (this.changeForm.valid) {
      const { currentPassword, newPassword } = this.changeForm.value;

      if (!currentPassword || !newPassword) {
        alert('Hasło nie może być puste!.');
        return;
      }

      const token: string | null = sessionStorage.getItem('jwt');

      if (token) {
        try {
          const decoded: any = jwtDecode(token);
          const email = decoded.sub;

          this.customerService.changePassword(email, currentPassword, newPassword).subscribe({
            next: () => {
              alert('Hasło zostało zmienione!.');
              this.router.navigate(['/zalogowany']).then(success => {
                if (success) {
                  console.log('Navigation successful');
                } else {
                  console.error('Navigation failed');
                }
              }).catch(err => {
                console.error('Navigation error:', err);
              });
            },
            error: error => {
              console.error('Error changing password:', error);
              if (error.status === 0) {
                alert('Brak internetu, spróbuj ponownie później.');
              } else {
                alert('Nieprawidłowe hasło!.');
              }
            }
          });
        } catch (err) {
          console.error('Error decoding token:', err);
          alert('Błąd uwierzytelniania.');
        }
      } else {
        alert('Brak tokenu uwierzytelniającego.');
      }
    } else {
      alert('Formularz jest nieprawidłowy.');
    }
  }


  hasMinLengthError() {
    const newPasswordControl = this.changeForm.get('newPassword');
    return newPasswordControl?.touched && newPasswordControl?.hasError('minlength');
  }

}
