import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class TrajetService {

  private baseUrl = 'http://localhost:8080/trajet';

  constructor(private http: HttpClient) {}

  createTrajet(data: any): Observable<any> {
    return this.http.post(this.baseUrl, data);
  }
}
