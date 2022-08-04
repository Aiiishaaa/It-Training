import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AdresseService {

  private url1: string = "http://localhost:8080/adresses";

  constructor(private http: HttpClient) { }
}
