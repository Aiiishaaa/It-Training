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
<<<<<<< HEAD
  {path: 'catalogue/:nomDomaine', component: CatalogueComponent},
  {path: 'catalogue/:nomDomaine/:nomTheme', component: CatalogueComponent},
=======
>>>>>>> 72f1931591126a7a71ce9e9b24b044dd273bc7ef
  {path: 'formateurs', component: FormateurComponent},
  {path: 'error', component: PageInconnuComponent},
  {path: '**', redirectTo: '/error'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
