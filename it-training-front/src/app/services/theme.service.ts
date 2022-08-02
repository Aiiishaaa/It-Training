import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Theme } from '../interfaces/theme';

@Injectable({
  providedIn: 'root'
})
export class ThemeService {

  private url1: string = "http://localhost:8080/themes";
  private url2: string = "http://localhost:8080/formations";

  constructor(private http: HttpClient) { }

  getAllTheme() {
    return this.http.get<Theme[]>(this.url1);
  }

  getOneThemeById(id: number) {
    return this.http.get<Theme>(this.url1 + "/" + id);
  }

  getOneThemeByFormation(idFormation: number) {
    return this.http.get<Theme>(this.url2 + "/" + idFormation + "/themes");
  }
}
