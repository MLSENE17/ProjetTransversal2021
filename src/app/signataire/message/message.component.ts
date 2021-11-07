import { Component, OnInit } from '@angular/core';
import { async } from '@angular/core/testing';
import { ActivatedRoute, Router } from '@angular/router';
import { SignataireService } from 'src/app/service/SignataireService';
import Swal from 'sweetalert2';
@Component({
  selector: 'app-message',
  templateUrl: './message.component.html',
  styleUrls: ['./message.component.css']
})
export class MessageComponent implements OnInit {
  id:any;
  validations:any;
  message:any
  constructor(private route:Router,
    private signataireService:SignataireService,
    private activeRoute:ActivatedRoute) { }

  ngOnInit(): void {
    this.id = this.activeRoute.snapshot.params.id
    this.getOne()
  }
  accept(){
    Swal.fire({
      title: 'Voulez vous vraiment accepter cette demande?',
      showDenyButton: true,
      confirmButtonText: 'Oui',
      denyButtonText: 'Non',
    }).then((result) => {
      /* Read more about isConfirmed, isDenied below */
      if (result.isConfirmed) {
        this.signataireService.signIn({id:this.id,response:"Accept",message:"bien Accepter"}).subscribe(
          (res)=>{
            Swal.fire({
              icon: 'success',
              title: 'Good',
              text: 'Demande bien enregistrer',
            })
             this.route.navigate(['signataire','home'])
          },
          (error)=>{
            Swal.fire({
              icon: 'error',
              title: 'Error',
              text: 'Erreur au niveau',
            })
          }
        )
      } 
    })
  }
  refuse(){
    Swal.fire({
      title: 'Voulez vous vraiment refuser cette demande?',
      showDenyButton: true,
      confirmButtonText: 'Oui',
      denyButtonText: 'Non',
    }).then((result) => {
      /* Read more about isConfirmed, isDenied below */
      if (result.isConfirmed) {
          this.main().then(
            ()=>{
              if(this.message){      
                  this.signataireService.signIn({id:this.id,response:"Refuse",message:this.message}).subscribe(
                    (res)=>{
                      Swal.fire({
                        icon: 'success',
                        title: 'Good',
                        text: 'Demande bien enregistrer',
                      })
                      this.route.navigate(['signataire','home'])
                    },
                    (error)=>{
                      Swal.fire({
                        icon: 'error',
                        title: 'Error',
                        text: 'Erreur au niveau',
                      })
                    }
                  )
              } 
            }
          )
      }
    })
  }
  getOne(){
    const menus= JSON.parse(localStorage.getItem('user')|| '{}')
    this.signataireService.getOne(this.id,menus.placeSignatory.id).subscribe(
      (res)=>{
        this.validations=res
        if(this.validations.response=='Accept'){
          Swal.fire({
            icon: 'info',
            title: 'Good',
            text: 'Cette demande a ete deja accepte',
          })
        }
      },
      (error)=>{
        this.route.navigate(['signataire','home'])
      }
    )
  }
  main = async()=>{
    const { value: text } = await Swal.fire({
      input: 'textarea',
      inputLabel: 'Motif du Refus \n Le motif du refus est obligatoire pour un refus',
      inputPlaceholder: 'Type your message here...',
      inputAttributes: {
        'aria-label': 'Type your message here',
        'required':'required'
      },
      showCancelButton: false,
      confirmButtonText:'Valider',
    })
    if (text) {
      this.message=text
    }
  }
}
