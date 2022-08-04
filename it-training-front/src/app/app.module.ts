import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { FormationComponent } from './composants/formation/formation.component';
import { CatalogueComponent } from './composants/catalogue/catalogue.component';
import { HeaderComponent } from './composants/header/header.component';
import { FooterComponent } from './composants/footer/footer.component';
import { AccueilComponent } from './composants/accueil/accueil.component';
import { PageInconnuComponent } from './composants/page-inconnu/page-inconnu.component';
import { FormateurComponent } from './composants/formateur/formateur.component';
import { KeysPipe } from './pipes/keys.pipe';


@NgModule({
  declarations: [
    AppComponent,
    FormationComponent,
    CatalogueComponent,
    HeaderComponent,
    FooterComponent,
    AccueilComponent,
    PageInconnuComponent,
    FormateurComponent,
    KeysPipe,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
