import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Formateur } from '../interfaces/formateur';

@Injectable({
  providedIn: 'root'
})
export class FormateurService {

  private url: string = "http://localhost:8080/formateurs";
  
  constructor(private http: HttpClient) { }

  getAllFormateurs() {
    return this.http.get<Formateur[]>(this.url);
  }

  getOneFormateurById(id: number) {
    return this.http.get<Formateur>(this.url + "/" + id);
  }
}
