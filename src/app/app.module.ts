
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ModalDialogModule } from 'ngx-modal-dialog';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AccueilComponent } from './Etudiant/accueil/accueil.component';
import { ServicesComponent } from './Etudiant/services/services.component';
import { ProgressionComponent } from './Etudiant/progression/progression.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { FormsModule } from '@angular/forms';
import { SweetAlert2Module } from '@sweetalert2/ngx-sweetalert2';
import { CompteComponent } from './Admin/compte/compte.component';
import { StatistiqueComponent } from './Admin/statistique/statistique.component';
import { ListeServComponent } from './Admin/liste-serv/liste-serv.component';
import { ListeComponent } from './Distributeur/liste/liste.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { DetailsComponent } from './Etudiant/progression/details/details.component';
import { PersonnelAuthComponent } from './personnel-auth/personnel-auth.component';
import { HeaderComponent } from './Partage/header/header.component';
import { FooterComponent } from './Partage/footer/footer.component';
import { HostService } from './service/HostService';
import { LoginService } from './service/LoginService';
import { AuthInterceptor } from './setting/AuthInterceptor';
import { HomeComponent } from './signataire/home/home.component';
import { DiplomeService } from './service/DiplomeService';
import { CompteService } from './service/CompteService';
import { EtudiantService } from './service/EtudiantService';
import { SignataireService } from './service/SignataireService';
import { MessageComponent } from './signataire/message/message.component';
import { VitrineComponent } from './vitrine/vitrine.component';
import { VitrineService } from './service/VitrineService';
import { SecretaireService } from './service/SecretaireService';
@NgModule({
  declarations: [
    AppComponent,
    AccueilComponent,
    ServicesComponent,
    ProgressionComponent,
    CompteComponent,
    StatistiqueComponent,
    ListeServComponent,
    ListeComponent,
    DetailsComponent,
    PersonnelAuthComponent,
    HeaderComponent,
    FooterComponent,
    HomeComponent,
    MessageComponent,
    VitrineComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    SweetAlert2Module,
    SweetAlert2Module.forRoot(),
    SweetAlert2Module.forChild({}),
    FormsModule,
    ReactiveFormsModule,
    NgbModule,
    ModalDialogModule.forRoot()
    
  ],
  providers: [
    HostService,
    LoginService,
    DiplomeService,
    CompteService,
    EtudiantService,
    SignataireService,
    VitrineService,
    SecretaireService,
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
