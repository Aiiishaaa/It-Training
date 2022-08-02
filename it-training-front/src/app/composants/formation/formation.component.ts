import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Employe } from 'src/app/interfaces/employe';
import { Formation } from 'src/app/interfaces/formation';
import { Prerequis } from 'src/app/interfaces/prerequis';
import { Session } from 'src/app/interfaces/session';
import { EmployeService } from 'src/app/services/employe.service';
import { FormationService } from 'src/app/services/formation.service';
import { SessionService } from 'src/app/services/session.service';

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
  prerequis: Prerequis = {};
  id: number = 0;

  constructor(
    private formationServ: FormationService,
    private sessionServ: SessionService,
    private employeServ: EmployeService,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(res => {
      this.id = Number(res.get("id"));
      this.recupFormation(this.id);
      this.recupSessionsParFormation(this.id);
      this.recupContactParFormation(this.id);
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
}
