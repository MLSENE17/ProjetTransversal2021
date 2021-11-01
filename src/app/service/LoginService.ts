import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HostService } from './HostService';
import { User } from '../model/User';
@Injectable()
export class LoginService{
   constructor(private http:HttpClient,private host:HostService){
   }
   getLogin(user:User){
       return this.http.post(this.host.getHost()+"auth/personel/signin",user);
   }
   getUser(email:string,role:string){
        if(role==="ROLE_ETUDIANT"){
            return this.http.get(this.host.getHost()+"etudiant/getUser?email="+email+"&role="+role);
        }
        return this.http.get(this.host.getHost()+"personnel/getUser?email="+email+"&role="+role);
   }
}