import { Injectable } from '@angular/core';
@Injectable()
export class HostService{
   getHost():string{
      return "http://localhost:8080/api/v1/"
   }
}