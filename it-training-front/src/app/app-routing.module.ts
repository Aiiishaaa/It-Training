import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AccueilComponent } from './composants/accueil/accueil.component';
import { CatalogueComponent } from './composants/catalogue/catalogue.component';
import { FormateurComponent } from './composants/formateur/formateur.component';
import { FormationComponent } from './composants/formation/formation.component';
import { PageInconnuComponent } from './composants/page-inconnu/page-inconnu.component';

const routes: Routes = [
  {path: '', component: AccueilComponent},
  {path: 'formations/:id', component: FormationComponent},
  {path: 'catalogue', component: CatalogueComponent},
  {path: 'formateurs', component: FormateurComponent},
  {path: 'error', component: PageInconnuComponent},
  {path: '**', redirectTo: '/error'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
