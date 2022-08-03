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
  i: number = 0;

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
    this.recupAllFormations();
    this.recupAllThemes();
    this.recupAllDomaines();
    this.route.paramMap.subscribe(res => {
    this.id = Number(res.get("id"));
    this.recupAllFormationsByDomaine(this.id);
    })
  }

  recupAllFormations() {
    this.fs.getAllFormations().subscribe(res => {
      console.log(res);
      this.formations = res;
      console.log(this.formations);    
    })
  }

  recupAllFormationsByDomaineName(name: string) {
    this.fs.getAllFormationsByDomaineName(name).subscribe(res => {
      console.log(res);
      this.formations = res;
      console.log(this.formations);    
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

  recupAllFormationsByDomaine(idDomaine: number) {
    this.fs.getAllFormationsByDomaine(idDomaine).subscribe(res => {
      this.formationsDom = res;
    })
  }

  recupFormationsMemeDomaine(idFormation: number) {
    let dom: Domaine;
    this.ds.getOneByFormation(idFormation).subscribe(res => {
      dom = res;
      this.fs.getAllFormationsByDomaine(dom.id ?? 0).subscribe(res => {
        let f = res;
        for (const elt of f) {
          if (elt.id != idFormation) {
            this.formationsMemeDomaine.push(elt);
          }
        }
      })
    })
  }


}
