import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CompteComponent } from './Admin/compte/compte.component';
import { ListeServComponent } from './Admin/liste-serv/liste-serv.component';
import { StatistiqueComponent } from './Admin/statistique/statistique.component';
import { AccueilComponent } from './Etudiant/accueil/accueil.component';
import { ProgressionComponent } from './Etudiant/progression/progression.component';
import {DetailsComponent} from './Etudiant/progression/details/details.component';
import { ServicesComponent } from './Etudiant/services/services.component';
import { ListeComponent } from './Distributeur/liste/liste.component';
import { PersonnelAuthComponent } from './personnel-auth/personnel-auth.component';
import { HomeComponent } from './signataire/home/home.component';
import { MessageComponent } from './signataire/message/message.component';
import { VitrineComponent } from './vitrine/vitrine.component';

const routes: Routes = [
  //accueil
  { path: '', component:  VitrineComponent },
  //{ path: '/', redirectTo:'personnel/login'},
  { path: 'login', component:  PersonnelAuthComponent },
  //etudiant
  { path: 'etudiant/compte', component: AccueilComponent },
  {path: 'etudiant/home', component: ServicesComponent},
  {path: 'etudiant/progression', component: ProgressionComponent},
  {path: 'etudiant/progression/:id', component: DetailsComponent},
  //admin
  {path: 'admin/diplomes', component: ListeServComponent},
  {path: 'admin/comptes', component: CompteComponent},
  {path: 'admin/home', component: StatistiqueComponent},
  //personne x
  {path: 'secretaire/home', component: ListeComponent},
  //signataire
  {path: 'signataire/home', component: HomeComponent},
  {path: 'signataire/home/message/:id', component: MessageComponent},
  {path: '**', redirectTo:""},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
 }
 