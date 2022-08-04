import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Session } from '../interfaces/session';

@Injectable({
  providedIn: 'root'
})
export class SessionService {

  private url1: string = "http://localhost:8080/sessions";
  private url2: string = "http://localhost:8080/formations";
  private url3: string = "http://localhost:8080/currentUser";

  constructor(private http: HttpClient) { }

  getAllSessionsByFormation(idFormation: number) {
    return this.http.get<Session[]>(this.url2 + "/" + idFormation + "/sessions");
  }

  getOneSessionById(id: number) {
    return this.http.get<Session>(this.url1 + "/" + id);
  }

  getAllSessionsByUser(idUser: number) {
    return this.http.get<Session[]>(this.url3 + "/sessions");
  }
}
