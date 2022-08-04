import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../interfaces/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private url1: string = "http://localhost:8080/users";
  private url2: string = "http://localhost:8080/formations";

  constructor( private http: HttpClient) { }

  getAllUser() {
    return this.http.get<User[]>(this.url1);
  }
  
  getOneUserById(id: number) {
    return this.http.get<User>(this.url1 + "/" + id);
  }
  
  getOneUserByFormation(idFormation: number) {
    return this.http.get<User>(this.url2 + "/" + idFormation + "/users");
  }
  
}
