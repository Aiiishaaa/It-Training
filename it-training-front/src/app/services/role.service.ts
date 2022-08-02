import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Role } from '../interfaces/role';

@Injectable({
  providedIn: 'root'
})
export class RoleService {

  private url: string = "http://localhost:8080/roles";

  constructor(private http: HttpClient) { }

  getAllRole() {
    return this.http.get<Role[]>(this.url);
  }

  getOneRoleById(id: number) {
    return this.http.get<Role>(this.url + "/" + id);
  }
}
