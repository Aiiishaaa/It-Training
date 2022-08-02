import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Employe } from '../interfaces/employe';

@Injectable({
  providedIn: 'root'
})
export class EmployeService {

  private url: string = "http://localhost:8080/employes";

  constructor(private http: HttpClient) { }

getAllEmploye() {
  return this.http.get<Employe[]>(this.url);
}

getOneEmployeById(id: number) {
  return this.http.get<Employe>(this.url + "/" + id);
}

}
