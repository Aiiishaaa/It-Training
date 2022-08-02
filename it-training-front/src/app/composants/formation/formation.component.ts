import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Domaine } from 'src/app/interfaces/domaine';
import { Employe } from 'src/app/interfaces/employe';
import { Formation } from 'src/app/interfaces/formation';
import { Prerequis } from 'src/app/interfaces/prerequis';
import { Session } from 'src/app/interfaces/session';
import { Theme } from 'src/app/interfaces/theme';
import { EmployeService } from 'src/app/services/employe.service';
import { FormationService } from 'src/app/services/formation.service';
import { SessionService } from 'src/app/services/session.service';
import { ThemeService } from 'src/app/services/theme.service';

@Component({
  selector: 'app-formation',
  templateUrl: './formation.component.html',
  styleUrls: ['./formation.component.css']
})
export class FormationComponent implements OnInit {

  formations: Formation[] = [];
  formation: Formation = {};
  sessions: Session[] = [];
  contact: Employe = {};
  theme: Theme = {};
  domaine: Domaine = {};
  prerequis: Prerequis = {};
  id: number = 0;

  constructor(
    private formationServ: FormationService,
    private sessionServ: SessionService,
    private employeServ: EmployeService,
    private themeServ: ThemeService,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(res => {
      this.id = Number(res.get("id"));
      this.recupFormation(this.id);
      this.recupSessionsParFormation(this.id);
      this.recupContactParFormation(this.id);
      this.recupThemeParFormation(this.id);
    });
  }

  recupFormation(id: number) {
    this.formationServ.getOneFormationById(id).subscribe(res => {
      this.formation = res;
    })
  }

  recupSessionsParFormation(idFormation: number) {
    this.sessionServ.getAllSessionsByFormation(idFormation).subscribe(res => {
      this.sessions = res; 
    })
  }

  recupContactParFormation(idFormation: number) {
    this.employeServ.getOneEmployeByFormation(idFormation).subscribe(res => {
      this.contact = res;
    })
  }

  recupThemeParFormation(idFormation: number) {
    this.themeServ.getOneThemeByFormation(idFormation).subscribe(res => {
      this.theme = res;
      console.log(this.theme);
    })
  }
}
