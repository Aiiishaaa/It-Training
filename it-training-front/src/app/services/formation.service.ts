import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Formation } from '../interfaces/formation';

@Injectable({
  providedIn: 'root'
})
export class FormationService {

  private url: string = "http://localhost:5555/formations";

  constructor(private http: HttpClient) { }

  getAllFormations() {
    return this.http.get<Formation[]>(this.url);
  }
}
