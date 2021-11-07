import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Title } from '@angular/platform-browser';
import { Data } from '@angular/router';
import { SecretaireService } from 'src/app/service/SecretaireService';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-liste',
  templateUrl: './liste.component.html',
  styleUrls: ['./liste.component.css']
})
export class ListeComponent implements OnInit {
  formModal=new FormGroup({
    etudiant:new FormControl('',[Validators.required])
  })
  loading:boolean=false;
  loading2:boolean=false;
  valide:boolean=false;
  nontrouve:boolean=false;
  demandes:any
  etudiant:any
  allSignature:any
  diplome:any
  retrait:any
  demande:any
  constructor(private secretaireService:SecretaireService,
    private title:Title) {this.title.setTitle("Secretaire RETRAIT DIPLOME") }

  ngOnInit(): void {
  }
  onSubmit(){
    this.demandes=null
    this.loading=true
    this.nontrouve=false
    this.etudiant=this.formModal.value.etudiant
    this.searchEtudiant(this.formModal.value.etudiant)
  }
  searchEtudiant(id:any){
    this.secretaireService.findEtudiant(id).subscribe(
      (res)=>{
        this.demandes=res 
        this.loading=false;
        if(this.demandes.length==0){
          console.log(this.demandes);   
          this.nontrouve=true
        }
      },
      (error)=>{
        this.loading=false;
        Swal.fire({
          icon: 'error',
          title: 'Oops...',
          text: error.error.message
        })
      }
    )
  }
  onVoirPlus(valide:boolean,demande:number,diplome:String){
    this.demande=demande;
    this.valide=valide;
    this.diplome = diplome
    this.secretaireService.getAllSign(demande,this.formModal.value.etudiant).subscribe(
      (res:Data)=>{
        this.allSignature=res.signature
        this.retrait=res.retrait
        
      }
    )
    let element: HTMLElement = document.getElementById('lamine') as HTMLElement;
    element.click();
  }
  valider(){
    Swal.fire({
      title: 'Voulez vous vraiment valider cette demande ?',
      showDenyButton: true,
      confirmButtonText: 'Oui',
      denyButtonText: 'Non',
    }).then((result) => {
      /* Read more about isConfirmed, isDenied below */
      if (result.isConfirmed) {
        this.loading2=true
        this.secretaireService.getValide(this.demande).subscribe(
          (res)=>{
            this.loading2=false
            Swal.fire({
              icon: 'success',
              title: 'Oops...',
              text: "Demande tres bien valider"
            })
            this.searchEtudiant(this.formModal.value.etudiant)
            let element: HTMLElement = document.getElementsByClassName('close')[0] as HTMLElement;
            element.click();
          },
          (error)=>{
            this.loading2=false
          }
        )
      }
    })
     
  }
}
