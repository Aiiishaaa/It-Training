import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Domaine } from '../interfaces/domaine';

@Injectable({
  providedIn: 'root'
})
export class DomaineService {

  private url: string = "http://localhost:8080/domaines";

  constructor(private http: HttpClient) { }

  getAllDomaines() {
    return this.http.get<Domaine[]>(this.url);
  }

  getOneEmployeById(id: number) {
    return this.http.get<Domaine>(this.url + "/" + id);
  }
}
