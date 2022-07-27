import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Formation } from '../interfaces/formation';

@Injectable({
  providedIn: 'root'
})
export class FormationService {

<<<<<<< HEAD
  private url: string = "http://localhost:4200/formations";
=======
  private url: string = "http://localhost:5555/formations";
>>>>>>> 27e1e8c7a71ff65c86d03821479090a07f086479

  constructor(private http: HttpClient) { }

  getAllFormations() {
    return this.http.get<Formation[]>(this.url);
  }
}
