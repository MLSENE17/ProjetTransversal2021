import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HostService } from './HostService';
import { User } from '../model/User';
@Injectable()
export class EtudiantService{
   constructor(private http:HttpClient,private host:HostService){
   }
   postDemane(diplome:any){
        return this.http.post(this.host.getHost()+"demande",diplome);
   }
   getHistorique(email:any){
       return this.http.get(this.host.getHost()+"demande/all/"+email)
   }
   getCours(email:any){
    return this.http.get(this.host.getHost()+"demande/encours/"+email)
  }
}