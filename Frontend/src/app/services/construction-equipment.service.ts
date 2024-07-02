import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {ConstructionEquipment} from "../models/construction-equipment.model";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class ConstructionEquipmentService {
  private apiUrl = 'http://localhost:8080/api/sprzet-budowlany'; // Replace with the actual URL of your API

  constructor(private http: HttpClient) { }

  getConstructionEquipment(): Observable<ConstructionEquipment[]> {
    return this.http.get<ConstructionEquipment[]>(this.apiUrl);
  }
}
