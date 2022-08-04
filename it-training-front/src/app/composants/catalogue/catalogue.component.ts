import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Domaine } from 'src/app/interfaces/domaine';
import { Formation } from 'src/app/interfaces/formation';
import { Theme } from 'src/app/interfaces/theme';
import { DomaineService } from 'src/app/services/domaine.service';
import { FormationService } from 'src/app/services/formation.service';
import { ThemeService } from 'src/app/services/theme.service';

@Component({
  selector: 'app-catalogue',
  templateUrl: './catalogue.component.html',
  styleUrls: ['./catalogue.component.css']
})
export class CatalogueComponent implements OnInit {

  lien: string = "http://localhost:4200/formations/";
  name!:string;
  formations: Formation[] = [];
  themes: Theme[] = [];
  domaines: Domaine[] = [];
  formationsMemeDomaine: Formation[] = [];

  formationsDom: Formation[] = [];
  id: number = 0;
  
  constructor(
    private ts: ThemeService,
    private fs: FormationService,
    private ds: DomaineService,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(res => {
    this.recupAllFormations();
    this.recupAllThemes();
    this.recupAllDomaines();
    })
  }

  recupAllFormations() {
    this.fs.getAllFormations().subscribe(res => {
      this.formations = res;
    })
  }

  recupAllDomaines() {
    this.ds.getAllDomaines().subscribe(res => {
      this.domaines = res;
    })
  }

  recupAllThemes() {
    this.ts.getAllTheme().subscribe(res => {
      this.themes = res;
    })
  }

  recupAllFormationsByDomaineName(name: string) {
    this.fs.getAllFormationsByDomaineName(name).subscribe(res => {
      this.formations = res;
    })
  }

  recupAllFormationByThemeName(name: string) {
    this.fs.getAllFormationsByThemeName(name).subscribe(res => {
      this.formations = res;
    })
  }

}
