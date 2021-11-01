import { AfterViewInit, Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, NgForm, Validators } from '@angular/forms';
import { DiplomeService } from 'src/app/service/DiplomeService';
import { EtudiantService } from 'src/app/service/EtudiantService';
import { GValidator } from '../../Partage/Validateurs/gvalidator';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-services',
  templateUrl: './services.component.html',
  styleUrls: ['./services.component.css']
})
export class ServicesComponent implements OnInit {
  diplomes:any
  loading:Boolean=false;
  demandes:any
  formModal=new FormGroup({
    diplome:new FormControl('',[Validators.required])
  })
  constructor(private diplomeService:DiplomeService,
    private etudiantService:EtudiantService) {
   // this.val = new GValidator(this.validationsMessages)
   }
  onSubmit(){
    this.loading=true
    const menus= JSON.parse(localStorage.getItem('user')|| '{}')
    this.etudiantService.postDemane({email:menus.email,diplome:this.formModal.value.diplome}).subscribe(
      (res)=>{
        this.loading=false;
        this.demandes=res;
        Swal.fire({
          icon: 'success',
          title: 'Oops...',
          text: "Demande bien enregistrer"
        })
        this.allDemande()
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
  ngOnInit(): void {
    this.allDiplome()
    this.allDemande()
  }
  allDiplome(){
    this.diplomeService.getAllDiplome().subscribe(
      (res)=>{
        this.diplomes=res;
        
        
      }
    )
  }
  allDemande(){
     const menus= JSON.parse(localStorage.getItem('user')|| '{}')
      this.etudiantService.getHistorique(menus.email).subscribe(
        (res)=>{
          this.demandes=res;
        }
      )
  }
}
