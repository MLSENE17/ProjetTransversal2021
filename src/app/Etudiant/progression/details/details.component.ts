import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Data, Router } from '@angular/router';
import { EtudiantService } from 'src/app/service/EtudiantService';
import Swal from 'sweetalert2';
@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css']
})
export class DetailsComponent implements OnInit {
  allSignature:any;
  id:any
  isValid:Boolean=false;
  InfoForm = new FormGroup({
    cni: new FormControl("", [
      Validators.required,
      Validators.minLength(10),
    ]),
    tel: new FormControl("", [
      Validators.required,
      Validators.minLength(9),
    ]),
  });

  constructor(
    private etudiantService:EtudiantService,
    private route:Router,
    private activeRoute:ActivatedRoute
  ) {
   }
  get f() { return this.InfoForm.controls ; }

  ngOnInit(): void {
    this.id = this.activeRoute.snapshot.params.id
    this.getAllSignature()
    this.getValid()
  }
  getAllSignature(){
    const menus= JSON.parse(localStorage.getItem('user')|| '{}')
    this.etudiantService.getSignature(this.id,menus.email).subscribe(
      (res)=>{
        this.allSignature=res;    
      },
      (error)=>{
        this.route.navigate(['/etudiant/progression'])
      }
    )
  }
  getValid(){
    const menus= JSON.parse(localStorage.getItem('user')|| '{}')
    this.etudiantService.getIsValid(this.id,menus.email).subscribe(
      (res)=>{
        this.isValid=true
        Swal.fire({
          icon: 'info',
          title: 'Retrait Diplome',
          text: 'Vous avez toute vos signatures pour cette demande.Veuiller recuperer votre diplome au niveau du secretariat',
        })
        this.etudiantService.getRetraits(this.id).subscribe(
          (res:Data)=>{
            this.InfoForm.controls.cni.setValue(res.cni)
            this.InfoForm.controls.tel.setValue(res.numero)
          }
        )
      },
      (error)=>{
        this.isValid=false
      }
    )
  }
  onSumbit(){
    this.etudiantService.saveRetraits(this.id,this.InfoForm.value.cni,this.InfoForm.value.tel).subscribe(
      (res)=>{
        Swal.fire({
          icon: 'info',
          title: 'Modification Reussi',
          text: 'Donnee tres bien modifier'
        })
      }
    )
  }
}
