import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HostService } from './HostService';
import { User } from '../model/User';
@Injectable()
export class SignataireService{
   constructor(private http:HttpClient,private host:HostService){
   }
   getAllSign(search:any){
       return this.http.post(this.host.getHost()+"signataire",search);
   }
   getOne(id:any,place:any){
    return this.http.get(this.host.getHost()+"signataire/"+id+"/"+place);
   }
   signIn(message:any){
    return this.http.post(this.host.getHost()+"signataire/demande",message);
   }
}