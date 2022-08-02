import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Formation } from 'src/app/interfaces/formation';
import { FormationService } from 'src/app/services/formation.service';

@Component({
  selector: 'app-catalogue',
  templateUrl: './catalogue.component.html',
  styleUrls: ['./catalogue.component.css']
})
export class CatalogueComponent implements OnInit {

  formations: Formation[] = [];
  
  constructor(
    private fs: FormationService,
    private route: ActivatedRoute

  ) { }

  ngOnInit(): void {
  }

}
