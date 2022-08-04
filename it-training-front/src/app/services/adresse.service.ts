import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Adresse } from '../interfaces/adresse';


@Injectable({
  providedIn: 'root'
})
export class AdresseService {
  private url: string = "http://localhost:8080/adresses";

  constructor(private http: HttpClient) { }

  getAllAdresse() {
    return this.http.get<Adresse[]>(this.url);
  }

  getOneAdresseById(id: number) {
    return this.http.get<Adresse>(this.url + "/" + id);
  }

  private url1: string = "http://localhost:8080/adresses";


}
