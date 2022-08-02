import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Prerequis } from '../interfaces/prerequis';

@Injectable({
  providedIn: 'root'
})
export class PrerequisService {

  private url: string = "http://localhost:8080/prerequis";

  constructor(private http: HttpClient) { }

  getAllPrerequis() {
    return this.http.get<Prerequis[]>(this.url);
  }

  getOnePrerequisById(id: number) {
    return this.http.get<Prerequis>(this.url + "/" + id);
  }
}
