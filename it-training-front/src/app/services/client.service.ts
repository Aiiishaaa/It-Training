import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Client } from '../interfaces/client';

@Injectable({
  providedIn: 'root'
})
export class ClientService {
    
  private url: string = "http://localhost:8080/clients";

  constructor(private http: HttpClient) { }

  getAllClients() {
    return this.http.get<Client[]>(this.url);
  }

  getOneClient(id: number) {
    return this.http.get<Client>(this.url + "/" + id);
  }

  addClient(u: Client) {
    return this.http.post(this.url, u);
  }

  updateClient(u: Client) {
    return this.http.put(this.url + "/" + u.id, u);
  }

  deleteClient(id: number) {
    return this.http.delete(this.url + "/" + id);
  }

  checkClient(email: string, password: string) {
    return this.http.get<Client[]>(this.url + "?email=" + email + "&motDePasse=" + password);
  }
}