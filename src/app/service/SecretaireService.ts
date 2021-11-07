import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { HostService } from './HostService';
@Injectable()
export class SecretaireService{
    constructor(private http:HttpClient,private host:HostService){
    }
    findEtudiant(etudiant:any){
        return this.http.get(this.host.getHost()+"secretaire/"+etudiant)
    }
    getAllSign(id:any,etudiant:any){
        return this.http.get(this.host.getHost()+"secretaire/valide/"+id+"/"+etudiant)
    }
    getValide(id:any){
        return this.http.get(this.host.getHost()+"secretaire/demande/"+id)
    }
}