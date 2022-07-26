import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CatalogueComponent } from './composants/catalogue/catalogue.component';
import { FormationComponent } from './composants/formation/formation.component';

const routes: Routes = [
  {path: 'formations', component: FormationComponent},
  {path: 'catalogue', component: CatalogueComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
