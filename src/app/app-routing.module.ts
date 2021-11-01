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
import { CorbeilleComponent } from './signataire/corbeille/corbeille.component';

const routes: Routes = [
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
  {path: 'liste', component: ListeComponent},
  //signataire
  {path: 'signataire/home', component: HomeComponent},
  {path: 'signataire/corbeille', component: CorbeilleComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
 }
