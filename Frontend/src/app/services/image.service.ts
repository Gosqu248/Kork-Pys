import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {ImageModel} from "../models/image.model";


@Injectable({
  providedIn: 'root'
})
export class ImageService {

  private apiUrl = 'http://localhost:8080/api/images'; // Replace with the actual URL of your API

  constructor(private http: HttpClient) { }

  getImagesByCategory(category: string): Observable<ImageModel[]> {
    return this.http.get<ImageModel[]>(`${this.apiUrl}?category=${category}`);
  }

  getImages(): Observable<ImageModel[]> {
    return this.http.get<ImageModel[]>(this.apiUrl);
  }
}
