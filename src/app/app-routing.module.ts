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

const routes: Routes = [{ path: 'etudiant/accueil', component: AccueilComponent },
                        {path: 'etudiant/services', component: ServicesComponent},
                        {path: 'etudiant/progression', component: ProgressionComponent},
                        {path: 'etudiant/progression/:id', component: DetailsComponent},
                        {path: 'admin/services', component: ListeServComponent},
                        {path: 'admin/comptes', component: CompteComponent},
                        {path: 'admin/statistiques', component: StatistiqueComponent},
                        {path: 'liste', component: ListeComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
 }
