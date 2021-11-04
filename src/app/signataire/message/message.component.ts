import { Component, OnInit } from '@angular/core';
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
        this.signataireService.signIn({id:this.id,response:"Accept"}).subscribe(
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

        this.signataireService.signIn({id:this.id,response:"Refuse"}).subscribe(
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

}
