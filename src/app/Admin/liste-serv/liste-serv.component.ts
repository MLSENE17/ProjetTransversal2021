import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { DiplomeService } from 'src/app/service/DiplomeService';
import Swal from 'sweetalert2';
@Component({
  selector: 'app-liste-serv',
  templateUrl: './liste-serv.component.html',
  styleUrls: ['./liste-serv.component.css']
})
export class ListeServComponent implements OnInit {
  diplome:any;
  oneDiplome:any;
  formModal=new FormGroup(
    {
      nameDiplome:new FormControl('',[Validators.required,Validators.minLength(3)])
    }
  )
  formModalUpdate=new FormGroup(
    {
      nameDiplome:new FormControl('',[Validators.required,Validators.minLength(3)])
    }
  )
  constructor(private route:Router,private  diplomeService:DiplomeService) { }

  ngOnInit() {
    this.getAll();
  }
  onSubmit(){
    this.diplomeService.createDiplome(this.formModal.value).subscribe(
      (res)=>{
        let element: HTMLElement = document.getElementsByClassName('close')[0] as HTMLElement;
        element.click();
        Swal.fire({
          icon: 'success',
          title: 'Oops...',
          text: 'Diplome '+this.formModal.value.nameDiplome+' bien creer'
        })
        this.getAll();
      },
      (error:any)=>{
        Swal.fire({
          icon: 'error',
          title: 'Oops...',
          text: 'Le nom '+this.formModal.value.nameDiplome+' existe deja'
        })
      }
    )
  }
  getAll(){
    this.diplomeService.getAllDiplome().subscribe(
      (res)=>{
        this.diplome=res;  
      }
    )
  }
  onUpdate(diplome:any){
     this.oneDiplome=diplome
     let element: HTMLElement = document.getElementById('lamine') as HTMLElement;
     this.formModalUpdate.controls.nameDiplome.setValue(this.oneDiplome.nomDiplome)
     element.click();
  }
  onSubmitUpdate(){
    this.diplomeService.updateDiplome(this.oneDiplome.id,this.formModalUpdate.value).subscribe(
      (res)=>{
        let element: HTMLElement = document.getElementById('lamine') as HTMLElement;
        element.click();
        Swal.fire({
          icon: 'success',
          title: 'Oops...',
          text: 'Diplome '+this.formModal.value.nameDiplome+' bien modifier'
        })
        this.getAll();
      },
      (error:any)=>{
        Swal.fire({
          icon: 'error',
          title: 'Oops...',
          text: 'Le nom '+this.formModal.value.nameDiplome+' existe deja'
        })
      }
    )
  }
}
