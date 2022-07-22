import { Component, OnInit } from '@angular/core';
import { Formation } from 'src/app/interfaces/formation';
import { FormationService } from 'src/app/services/formation.service';

@Component({
  selector: 'app-formation',
  templateUrl: './formation.component.html',
  styleUrls: ['./formation.component.css']
})
export class FormationComponent implements OnInit {

  formations: Formation[] = [];
  formation: Formation = {};

  constructor(private fs:FormationService) { }

  ngOnInit(): void {
    this.recupFormations();
  }

  recupFormations() {
    this.fs.getAllFormations().subscribe(res => {
      this.formations = res;
    })
  }
}
