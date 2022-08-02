import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Theme } from '../interfaces/theme';

@Injectable({
  providedIn: 'root'
})
export class ThemeService {

  private url: string = "http://localhost:8080/themes";

  constructor(private http: HttpClient) { }

  getAllTheme() {
    return this.http.get<Theme[]>(this.url);
  }

  getOneThemeById(id: number) {
    return this.http.get<Theme>(this.url + "/" + id);
  }
}
