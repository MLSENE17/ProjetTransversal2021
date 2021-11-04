import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { iif } from 'rxjs';
import Swal from 'sweetalert2';
import { VitrineService } from '../service/VitrineService';

@Component({
  selector: 'app-vitrine',
  templateUrl: './vitrine.component.html',
  styleUrls: ['./vitrine.component.css']
})
export class VitrineComponent implements OnInit {
  isTrue:boolean=false
  etudiant:any;
  isLoading:boolean=false
  InfoForm = new FormGroup({
    etudiant: new FormControl("", [
      Validators.required,
    ]),
  });
  InscriptionForm = new FormGroup({
    email: new FormControl("", [
      Validators.required,
    ]),
    prenom: new FormControl("", [
      Validators.required,
    ]),
    nom: new FormControl("", [
      Validators.required,
    ]),
    cni: new FormControl("", [
      Validators.required,
      Validators.minLength(13),
    ]),
    password: new FormControl("", [
      Validators.required,
      Validators.minLength(4),
    ]),
    confirmpassword: new FormControl("", [
      Validators.required,
      Validators.minLength(4),
    ]),
    numeroEtudiant: new FormControl("", [
      Validators.required,
    ]),
    place: new FormControl("", [
      Validators.required,
    ]),
    dateNaissance: new FormControl("", [
      Validators.required
    ]),
    numeroTelephone:new FormControl("", [
      Validators.required,
    ]),
    option:new FormControl("", [
      Validators.required,
    ]),
  });
  constructor(
    private router: Router,
    private vitrineService:VitrineService
  ) { }

  saveDemande() : void{
    this.vitrineService.getUser(this.InfoForm.value.etudiant).subscribe(
      (res)=>{
        if(res==null){
          Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: "Cet etudiant n'existe pas"
          })
        }else{
         this.etudiant=res;
         this.InscriptionForm.controls.email.setValue(this.etudiant.email)
         this.InscriptionForm.controls.prenom.setValue(this.etudiant.prenom)
         this.InscriptionForm.controls.nom.setValue(this.etudiant.nom)
         this.InscriptionForm.controls.cni.setValue(this.etudiant.cni)
         this.InscriptionForm.controls.numeroEtudiant.setValue(this.etudiant.numeroetudiant)
         this.InscriptionForm.controls.dateNaissance.setValue(this.etudiant.dateNaissance)
         this.InscriptionForm.controls.place.setValue(this.etudiant.placeSignatory.id)
         this.isTrue=true;
        }
         
      },
      (error)=>{
          
      }
    )
  }

  saveInscription() : void{
     if(this.InscriptionForm.value.password!==this.InscriptionForm.value.confirmpassword){
      Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: "Veuillez entrer des mot de pass identiques"
      })
     }else{
       console.log(this.InscriptionForm.value);
     }
  }

  ngOnInit(): void {
  }
  get fInfo() { return this.InfoForm.controls; }
  get fSign() { return this.InscriptionForm.controls; }
  appJs(){
    const hamburger = document.querySelector('.header .nav-bar .nav-list .hamburger');
    const mobile_menu = document.querySelector('.header .nav-bar .nav-list ul');
    const menu_item = document.querySelectorAll('.header .nav-bar .nav-list ul li a');
    const header = document.querySelector('.header.container');
  
  }


}
