import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Client } from 'src/app/interfaces/client';
import { ClientService } from 'src/app/services/client.service';
@Component({
  selector: 'app-accueil',
  templateUrl: './accueil.component.html',
  styleUrls: ['./accueil.component.css']
})
export class AccueilComponent implements OnInit {
  constructor(private cs: ClientService) { }
  client: Client = {};
  clients: Client[] = [];
  prenom: string = "";
  nom: string = "";
  email: string = "";
  motDePasse: string = "";
  id?: number;
  isIdentified: boolean = false;
  isNewUser: boolean = false;
  message: string = "";
  ngOnInit(): void {
    this.initClient();
  }

  ajouterClient() {
    this.cs.addClient(this.client).subscribe(res => {
      this.initClient();
    })
    this.client = {};
  }
  initClient() {
    throw new Error('Method not implemented.');
  }
  initProduit() {
    this.cs.getAllProducts().subscribe(res => {
      this.clients = res;
    });
  }
  supprimerClient(id=0) {
    this.cs.deleteClient(id).subscribe(res => {
      this.initClient();
    })
  }
 

}