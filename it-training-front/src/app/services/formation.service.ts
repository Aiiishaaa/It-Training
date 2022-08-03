import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Formation } from '../interfaces/formation';

@Injectable({
  providedIn: 'root'
})
export class FormationService {

  private url1: string = "http://localhost:8080/formations";
  private url2: string = "http://localhost:8080/domaines";
  private url3: string = "http://localhost:8080/forms";
  private url4: string = "http://localhost:8080/forma";

  constructor(private http: HttpClient) { }

  getAllFormations() {
    return this.http.get<Formation[]>(this.url1);
  }

  getOneFormationById(id: number) {
    return this.http.get<Formation>(this.url1 + "/" + id);
  }

  getAllFormationsByDomaine(id: number) {
    return this.http.get<Formation[]>(this.url2+ "/" + id + "/formations");
  }

  getAllFormationsByDomaineName(nomDomaine: string) {
    return this.http.get<Formation[]>(this.url3 + "/" + nomDomaine);
  }

  getAllFormationsByThemeName(nomTheme: string) {
    return this.http.get<Formation[]>(this.url4 + "/" + nomTheme);
  }
}
