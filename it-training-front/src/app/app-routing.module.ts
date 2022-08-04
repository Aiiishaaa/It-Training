import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AccueilComponent } from './composants/accueil/accueil.component';
import { CatalogueComponent } from './composants/catalogue/catalogue.component';
import { ConnexionComponent } from './composants/connexion/connexion.component';
import { FormateurComponent } from './composants/formateur/formateur.component';
import { FormationComponent } from './composants/formation/formation.component';
import { PageInconnuComponent } from './composants/page-inconnu/page-inconnu.component';
import { TableauDeBordComponent } from './composants/tableau-de-bord/tableau-de-bord.component';
import { UserComponent } from './composants/user/user.component';

const routes: Routes = [
  {path: 'accueil', component: AccueilComponent},
  {path: 'Dashboard', component: TableauDeBordComponent},
  {path: 'catalogue', component: CatalogueComponent},
  {path: 'catalogue/:nomDomaine', component: CatalogueComponent},
  {path: 'catalogue/:nomDomaine/:nomTheme', component: CatalogueComponent},
  {path: 'formations/:id', component: FormationComponent},
  {path: 'formateurs', component: FormateurComponent},
  {path: 'signup', component: ConnexionComponent},
  {path: 'auth/login',component: ConnexionComponent},
  {path: 'user', component: UserComponent},
  {path: '', redirectTo:'accueil', pathMatch:'full'},  
  {path: 'error', component: PageInconnuComponent},
  {path: '**', redirectTo: '/error'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
