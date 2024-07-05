import { Component } from '@angular/core';
import {UserMainComponent} from "../user-main/user-main.component";

@Component({
  selector: 'app-home-user',
  standalone: true,
  imports: [
    UserMainComponent
  ],
  templateUrl: './home-user.component.html',
  styleUrl: './home-user.component.css'
})
export class HomeUserComponent {

}
