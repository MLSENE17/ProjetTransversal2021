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
  getSignature(id:any,email:any){
    return this.http.get(this.host.getHost()+"validation/"+id+"/"+email)
  }
  getIsValid(id:any,email:any){
    return this.http.get(this.host.getHost()+"validation/valid/"+id+"/"+email)
  }
  getRetraits(id:any){
    return this.http.get(this.host.getHost()+"retrait/"+id)
  }
  saveRetraits(id:any,cni:any,numero:any){
    return this.http.get(this.host.getHost()+"retrait/save/"+id+"/"+cni+"/"+numero)
  }
}