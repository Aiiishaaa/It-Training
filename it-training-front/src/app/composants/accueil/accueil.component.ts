import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Client } from 'src/app/interfaces/client';
import { ClientService } from 'src/app/services/client.service';
@Component({
  selector: 'app-accueil',
  templateUrl: './accueil.component.html',
  styleUrls: ['./accueil.component.css']
})
export class AccueilComponent implements OnInit {
  constructor(
    private cs : ClientService,
    private router: Router,
    private route: ActivatedRoute) { }

  client: Client = {};
  clients: Client[] = [];
initClient() {
 }

  ngOnInit() {
    this.initClient();
    this.getAllClients();
  }
  getAllClients() {
    this.cs.getAllClients().subscribe(
      data => {
        this.clients = data;
      }
    );
  }
  addClient() {
    this.cs.addClient(this.client).subscribe(
      data => {
        this.getAllClients();
      }
    );
  }
  deleteClient(id: number) {
    this.cs.deleteClient(id).subscribe(
      data => {
        this.getAllClients();
      }

    );
  }
  updateClient(client: Client) {
    this.cs.updateClient(client).subscribe(
      data => {
        this.getAllClients();
      }
    );
  }

  checkClient(email: string, password: string) {
    this.cs.checkClient(email, password).subscribe(
      data => {
        this.clients = data;
      }
    );
  }
 
}