import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../auth/auth.service';
import { TokenStorageService } from '../../auth/token-storage.service';
import { AuthLoginInfo } from '../../auth/login-info';
import { Router } from '@angular/router';


@Component({
  selector: 'app-connexion',
  templateUrl: './connexion.component.html',
  styleUrls: ['./connexion.component.css']
})
export class ConnexionComponent implements OnInit {

  form: any = {};
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  roles: string[] = [];
  private loginInfo?: AuthLoginInfo;

  constructor(private authService: AuthService,
    private tokenStorage: TokenStorageService,
    private router: Router) { }

  ngOnInit() {
    if (this.tokenStorage.getToken()) {
      this.isLoggedIn = true;
      this.roles = this.tokenStorage.getAuthorities();
    }
  }

  onSubmit() {
    console.log(this.form);

    this.loginInfo = new AuthLoginInfo(
      this.form.username,
      this.form.password);

    this.authService.attemptAuth(this.loginInfo).subscribe(
      data => {
        this.tokenStorage.saveToken(data.accessToken);
        this.tokenStorage.saveUsername(data.username);
        this.tokenStorage.saveAuthorities(data.authorities);

        this.isLoginFailed = false;
        this.isLoggedIn = true;
        this.roles = this.tokenStorage.getAuthorities();
        if (this.roles.indexOf("admin") != -1) {
          this.reloadPage(1);
        }
        else if (this.roles.indexOf("employe") != -1) {
          this.reloadPage(2);
        }
        else {
          this.reloadPage(3);
        }
      },
      error => {
        console.log(error);
        this.errorMessage = error.error.message;
        this.isLoginFailed = true;
      }
    );
  }

  reloadPage(i: number) {
    //window.location.reload();
    switch (i) {
      case 1:
        this.router.navigate(['/dashboard']);
        break;
      case 2:
        this.router.navigate(['']);
        break;
      case 3:
        this.router.navigate(['/user']);
        break;
      default:
        console.log("Erreur routage");
    }


  }
}
