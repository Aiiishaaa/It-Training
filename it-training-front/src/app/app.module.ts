import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { FormationComponent } from './composants/formation/formation.component';
import { CatalogueComponent } from './composants/catalogue/catalogue.component';
import { FooterComponent } from './composants/footer/footer.component';
import { AccueilComponent } from './composants/accueil/accueil.component';
import { PageInconnuComponent } from './composants/page-inconnu/page-inconnu.component';
import { FormateurComponent } from './composants/formateur/formateur.component';
import { NavbarComponent } from './composants/navbar/navbar.component';


@NgModule({
  declarations: [
    AppComponent,
    FormationComponent,
    CatalogueComponent,
    FooterComponent,
    AccueilComponent,
    PageInconnuComponent,
    FormateurComponent,
    NavbarComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
