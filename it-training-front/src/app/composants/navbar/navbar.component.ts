import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthService } from 'src/app/auth/auth.service';
import { TokenStorageService } from 'src/app/auth/token-storage.service';
import { UserService } from 'src/app/services/user.service';
import  'src/assets/js/main.js';


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

  
  private roles: string[] = [];
  authority: string = "";
  
  constructor(private authService: AuthService, private token: TokenStorageService) { }
 
  ngOnInit() {
    if (this.token.getToken()) {
      this.roles = this.token.getAuthorities();
      this.roles.every(role => {
        if (role === 'ROLE_ADMIN') {
          this.authority = 'tableau-de-bord';
          return false;
        } else if (role === 'ROLE_PM') {
          this.authority = 'user';
          return false;
        }
        this.authority = 'user';
        return true;
      });
    }
  }
  logout() {
    this.token.signOut();
    window.location.reload();
  }

}
