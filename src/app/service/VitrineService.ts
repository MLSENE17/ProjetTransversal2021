import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HostService } from './HostService';
import { User } from '../model/User';
@Injectable()
export class VitrineService{
   constructor(private http:HttpClient,private host:HostService){
   }
   getUser(etudiant:any){
       return this.http.get(this.host.getHost()+"auth/crent/"+etudiant);
   }
   getSignup(etudiant:any){
    return this.http.post(this.host.getHost()+"auth/etudiant/signup",etudiant);
   }   
}