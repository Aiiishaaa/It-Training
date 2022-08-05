import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../interfaces/user';
import { Observable } from 'rxjs';
 
@Injectable({
  providedIn: 'root'
})
export class UserService {

  private url1: string = "http://localhost:8080/users";
  private url2: string = "http://localhost:8080/formations";
  private url3: string = "http://localhost:8080/currentUser";
  private userUrl = 'http://localhost:8080/api/test/user';
  private pmUrl = 'http://localhost:8080/api/test/pm';
  private adminUrl = 'http://localhost:8080/api/test/admin';

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
  
  getUserBoard(): Observable<string> {
    return this.http.get(this.userUrl, { responseType: 'text' });
  }
 
  getPMBoard(): Observable<string> {
    return this.http.get(this.pmUrl, { responseType: 'text' });
  }
 
  getAdminBoard(): Observable<string> {
    return this.http.get(this.adminUrl, { responseType: 'text' });
  }

  // getOneUserByUsername(username: string) {
  //   return this.http.get<User>(this.url1 + '/' + username);
  // }

  getOneUserByUsername(username: string) {
    return this.http.get<User>(this.url3);
  }
}
