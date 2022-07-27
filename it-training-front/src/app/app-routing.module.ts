import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CatalogueComponent } from './composants/catalogue/catalogue.component';
import { FormationComponent } from './composants/formation/formation.component';

const routes: Routes = [
  {path: 'catalogue', component: CatalogueComponent},
  {path: 'formations', component: FormationComponent},
  {path: 'formations/:id', component: FormationComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
