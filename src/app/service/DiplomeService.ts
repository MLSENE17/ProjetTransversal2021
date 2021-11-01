import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HostService } from './HostService';
import { User } from '../model/User';
@Injectable()
export class DiplomeService{
   constructor(private http:HttpClient,private host:HostService){
   }
   getAllDiplome(){
        return this.http.get(this.host.getHost()+"diplome/all");
   }
   createDiplome(nameDiplome:any){
       return this.http.post(this.host.getHost()+"diplome/create",nameDiplome);
   }
   updateDiplome(id:any,nameDiplome:any){
    return this.http.put(this.host.getHost()+"diplome/update/"+id,nameDiplome);
    }
}