import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Title } from '@angular/platform-browser';
import { Router } from '@angular/router';
import { SignataireService } from 'src/app/service/SignataireService';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  messages:any;
  formModal=new FormGroup({
      status:new FormControl(''),
      numero:new FormControl('')
  })
  constructor(private title:Title,private signataireService:SignataireService,
    private route:Router) { this.title.setTitle("Signataire|Reception")}
 
  ngOnInit(): void {
    this.getAllMessage()
  }
  onUpdate(id:any){
    this.route.navigate(['signataire','home','message',id])
  }
  numEtudiant(){
     const input =this.formModal.value.numero;
     if(input.length>6){
      this.getAllMessage()
     }
  }
  getAllMessage():void{
    this.signataireService.getAllSign(this.getForm()).subscribe(
      (res)=>{
        this.messages=res     
      }
    )
  }
  getStatus(){
    const select = this.formModal.value.status
    if(select){
      this.getAllMessage()
    }
 
  }
  refresh(){
    this.formModal.controls.status.setValue('')
    this.formModal.controls.numero.setValue('')
    this.getAllMessage()
  }
  getForm(){
    const menus= JSON.parse(localStorage.getItem('user')|| '{}')
     let donne={
        id:menus.placeSignatory.id,
        numero:this.formModal.value.numero?this.formModal.value.numero:null,
        status:this.formModal.value.status?this.formModal.value.status:null
     }     
     return donne;
  }
}
