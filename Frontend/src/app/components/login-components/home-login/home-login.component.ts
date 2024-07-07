import {Component, OnInit} from '@angular/core';
import {LoginMainComponent} from "../login-main/login-main.component";


@Component({
  selector: 'app-home-login',
  standalone: true,
  imports: [
    LoginMainComponent
  ],
  templateUrl: './home-login.component.html',
  styleUrl: './home-login.component.css'
})
export class HomeLoginComponent {

}
