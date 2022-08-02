import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Domaine } from '../interfaces/domaine';

@Injectable({
  providedIn: 'root'
})
export class DomaineService {

  private url1: string = "http://localhost:8080/domaines";
  private url2: string = "http://localhost:8080/formations";

  constructor(private http: HttpClient) { }

  getAllDomaines() {
    return this.http.get<Domaine[]>(this.url1);
  }
  
  getOneEmployeById(id: number) {
    return this.http.get<Domaine>(this.url1 + "/" + id);
  }

  getOneByFormation(idFormation: number) {
    return this.http.get<Domaine>(this.url2 + "/" + idFormation + "/domaines");
  }
}
