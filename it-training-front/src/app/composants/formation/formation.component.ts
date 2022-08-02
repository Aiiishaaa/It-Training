import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
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
  id: number = 0;

  constructor(
    private fs: FormationService,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(res => {
      this.id = Number(res.get("id"));
      this.recupFormation(this.id);
      console.log(this.id)
    });
  }

  recupFormation(id: number) {
    this.fs.getOneFormationById(id).subscribe(res => {
      this.formation = res;
    })
  }
}
