import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Title } from '@angular/platform-browser';
import { Data, Router } from '@angular/router';
import { LoginService } from '../service/LoginService';

@Component({
  selector: 'app-personnel-auth',
  templateUrl: './personnel-auth.component.html',
  styleUrls: ['./personnel-auth.component.css']
})
export class PersonnelAuthComponent implements OnInit {
   formModal = new FormGroup(
     {
       email:new FormControl('',[Validators.email,Validators.required]),
       password:new FormControl('',[Validators.required])
     }
   )
   loading:Boolean=false;
  constructor(private title:Title,
    private loginService:LoginService,
    private route:Router) { 
    title.setTitle("Login")
    if(localStorage.getItem("token")&& localStorage.getItem("user") && localStorage.getItem("menu")){
      const menus= JSON.parse(localStorage.getItem('user')|| '{}')
      this.route.navigate([menus.urlHome])
    }else{
      localStorage.clear()
    }
  }
  onSubmit(){
    this.loading=true;
     this.loginService.getLogin(this.formModal.value).subscribe(
        (res:Data)=>{
          localStorage.setItem("token",res.token);
          this.loginService.getUser(res.email,res.roles[0]).subscribe(
            (res:Data)=>{
              localStorage.setItem("user", JSON.stringify(res.user));
              localStorage.setItem("menu", JSON.stringify(res.menu));
              this.route.navigate([res.user.urlHome]);
            },
            (error)=>{
              localStorage.clear()
            
            }
          );
        },
        (error:any)=>{
          alert("email ou mot de pass incorrect")
          this.loading=false;
        }
      )
   }
  ngOnInit(): void {
    if(localStorage.getItem("token") && localStorage.getItem("menu")){
      console.log("lamine")
    }
  }

}
