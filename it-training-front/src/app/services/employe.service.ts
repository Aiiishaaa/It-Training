import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Employe } from '../interfaces/employe';

@Injectable({
  providedIn: 'root'
})
export class EmployeService {

  private url1: string = "http://localhost:8080/employes";
  private url2: string = "http://localhost:8080/formations";

  constructor(private http: HttpClient) { }

getAllEmploye() {
  return this.http.get<Employe[]>(this.url1);
}

getOneEmployeById(id: number) {
  return this.http.get<Employe>(this.url1 + "/" + id);
}

getOneEmployeByFormation(idFormation: number) {
  return this.http.get<Employe>(this.url2 + "/" + idFormation + "/employes");
}

}
