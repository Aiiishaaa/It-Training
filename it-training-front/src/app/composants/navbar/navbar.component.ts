import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Client } from 'src/app/interfaces/client';
import { ClientService } from 'src/app/services/client.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  titre = 'IT TRAINING';

  erreur = true;
  email: string = '';
  password: string = '';

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  isAuthenticated() {
    if (this.email === 'John' && this.password === '1234') {
      localStorage.setItem('isConnected', 'true');
      this.router.navigateByUrl('/client');
    } else {
      this.erreur = false;
    }
  }}