import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { CompteService } from 'src/app/service/CompteService';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-compte',
  templateUrl: './compte.component.html',
  styleUrls: ['./compte.component.css']
})
export class CompteComponent implements OnInit {
  isActive:Boolean=false;
  places:any;
  users:any;
  formModal=new FormGroup({
    prenom:new FormControl('',[Validators.required,Validators.minLength(2)]),
    nom:new FormControl('',[Validators.required,Validators.minLength(2)]),
    email:new FormControl('',[Validators.email ,Validators.required,Validators.minLength(2)]),
    role:new FormControl('ADMIN',[Validators.required]),
    place:new FormControl('1',[Validators.required]),
  })
  constructor(private compteService:CompteService) { }

  ngOnInit(): void {
    this.getAllPlace()
    this.getUser()
  }
  onDelete(id:any,email:any){
    Swal.fire({
      title: 'Voulez vous supprimer cet utilisateur?',
      showDenyButton: true,
      confirmButtonText: 'Oui',
      denyButtonText: 'Non',
    }).then((result) => {
      /* Read more about isConfirmed, isDenied below */
      if (result.isConfirmed) {
        this.compteService.delete(id,email).subscribe(
          (res)=>{
            Swal.fire({
              icon: 'success',
              title: 'Oops...',
              text: 'User bien supprimer'
            })
            this.getUser()
          },
          (error)=>{
            Swal.fire({
              icon: 'error',
              title: 'Oops...',
              text: 'User non supprimer'
            })
          }
        )
      } 
    })
   
   
  }
  getAllPlace(){
    this.compteService.getAllPlace().subscribe(
      (res)=>{
        
          this.places=res;        
      }
    )
  }
  onChangeRole(){
    const a= this.formModal.value.role
    if(a==="SIGNATAIRE"){
      this.isActive=true
      this.formModal.controls.place.setValue('')
    }else{
      this.isActive=false
      this.formModal.controls.place.setValue('1')
     
    }
  }
  onSubmit(){
    this.compteService.createUser(this.formModal.value).subscribe(
      (res)=>{
        let element: HTMLElement = document.getElementsByClassName('close')[0] as HTMLElement;
        element.click();
        Swal.fire({
          icon: 'success',
          title: 'Oops...',
          text: 'User bien supprimer'
        })
          this.getUser()
      },
      (error)=>{
        Swal.fire({
          icon: 'error',
          title: 'Oops...',
          text: error.error.message
        })
      }
    )
  }
  getUser(){
    this.compteService.getAllUsers().subscribe(
      (res)=>{
        this.users=res
      }
    )
  }
}
