import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { TokenStorageService } from 'src/app/auth/token-storage.service';
import { Adresse } from 'src/app/interfaces/adresse';
import { Domaine } from 'src/app/interfaces/domaine';
import { Formateur } from 'src/app/interfaces/formateur';
import { Formation } from 'src/app/interfaces/formation';
import { Prerequis } from 'src/app/interfaces/prerequis';
import { Session } from 'src/app/interfaces/session';
import { Theme } from 'src/app/interfaces/theme';
import { User } from 'src/app/interfaces/user';
import { DomaineService } from 'src/app/services/domaine.service';
import { EmployeService } from 'src/app/services/employe.service';
import { FormationService } from 'src/app/services/formation.service';
import { SessionService } from 'src/app/services/session.service';
import { ThemeService } from 'src/app/services/theme.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-formation',
  templateUrl: './formation.component.html',
  styleUrls: ['./formation.component.css']
})
export class FormationComponent implements OnInit {
  formationsMemeDomaine: Formation[] = [];
  formation: Formation = {};
  formateur!: Formateur;
  sessions: Session[] = [];
  contact: User = {};
  theme!: Theme;
  domaine!: Domaine;
  prerequis: Prerequis = {};
  id: number = 0;
  urlBackground: string = "";
  adresse: Adresse = {};
  codePostal: string = "";
  lieux: string[] = [];
  formateurs: string[] = [];
  userName: string = "";

  inscriptions: Session[] = [];

  constructor(
    private formationServ: FormationService,
    private sessionServ: SessionService,
    private userServ: UserService,
    private themeServ: ThemeService,
    private domaineServ: DomaineService,
    private token: TokenStorageService,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(res => {
      this.id = Number(res.get("id"));
      this.recupFormation(this.id);
      this.recupSessionsParFormation(this.id);
      this.recupContactParFormation(this.id);
      this.recupThemeParFormation(this.id);
      this.recupDomaineParFormation(this.id);
      this.recupFormationsMemeDomaine(this.id);
      this.recupInscriptionsClient();
      this.userName = this.token.getUsername();
    });
  }

  recupFormation(id: number) {
    this.formationServ.getOneFormationById(id).subscribe(res => {
      console.log(res);
      this.formation = res;
    })
  }

  recupSessionsParFormation(idFormation: number) {
    this.sessionServ.getAllSessionsByFormation(idFormation).subscribe(res => {
      this.sessions = res;
      this.recupInfosSessions(this.sessions);
      console.log(this.sessions);
    })
  }

  recupContactParFormation(idFormation: number) {
    this.userServ.getOneUserByFormation(idFormation).subscribe(res => {
      this.contact = res;
    })
  }

  recupThemeParFormation(idFormation: number) {
    this.themeServ.getOneThemeByFormation(idFormation).subscribe(res => {
      this.theme = res;
    })
  }

  recupDomaineParFormation(idFormation: number) {
    this.domaineServ.getOneByFormation(idFormation).subscribe(res => {
      this.domaine = res;
      switch (this.domaine.id) {
        case 1:
          this.urlBackground = "/assets/images/work-6.jpg";
          break;
        case 2:
          this.urlBackground = "/assets/images/work-5.jpg";
          break;
        default:
          console.log("Erreur chargement background");
      }

    })
  }

  recupFormationsMemeDomaine(idFormation: number) {
    let dom: Domaine;
    this.domaineServ.getOneByFormation(idFormation).subscribe(res => {
      dom = res;
      this.formationServ.getAllFormationsByDomaine(dom.id ?? 0).subscribe(res => {
        let f = res;
        for (const elt of f) {
          if (elt.id != idFormation) {
            this.formationsMemeDomaine.push(elt);
          }
        }
      })
    })
  }

  recupInfosSessions(s: Session[]) {
    for (const elt of s) {
      this.lieux.push(`${elt.adresse?.codePostal} ${elt.adresse?.ville}` ?? "");
      this.formateurs.push(`${elt.formateur?.prenomFormateur} ${elt.formateur?.nomFormateur}` ?? "");
      console.log(this.formateurs);
    }
  }

  recupInscriptionsClient() {
    this.sessionServ.getAllSessionsByUser().subscribe( res => {
      this.inscriptions = res;
    })
  }

  sInscrire() {
    
  }
}
