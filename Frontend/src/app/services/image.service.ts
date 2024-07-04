import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {map, Observable} from "rxjs";
import {ImageModel} from "../models/image.model";


@Injectable({
  providedIn: 'root'
})
export class ImageService {

  private apiUrl = 'http://localhost:8080/api/images'; // Replace with the actual URL of your API

  constructor(private http: HttpClient) { }


  getCategoryImages(category: string): Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl).pipe(
      map(images => images.filter(image => image.category === category))
    );
  }
}
