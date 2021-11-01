import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HostService } from './HostService';
@Injectable()
export class CompteService{
   constructor(private http:HttpClient,private host:HostService){
   }
   getAllPlace(){
       return this.http.get(this.host.getHost()+"placesignator/all");
   }
   getAllUsers(){
    return this.http.get(this.host.getHost()+"auth/personel/all");
    }
    delete(id:any,email:any){
       return this.http.delete(this.host.getHost()+"auth/personel/delete/"+id+"/"+email)
    }
    createUser(user:any){
        return this.http.post(this.host.getHost()+"auth/personel/signup",user);
    }
}