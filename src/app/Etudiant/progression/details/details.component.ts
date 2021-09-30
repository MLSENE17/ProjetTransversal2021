import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ListeService } from '../liste.service';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css']
})
export class DetailsComponent implements OnInit {

  public MaListe : any= <any>{};

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private Listedemande: ListeService,
  ) { }
  public InfoForm :any = [];
  public saveDemande() : void{
    alert("Bien")
    console.log(this.InfoForm.value.cni);
    console.log(this.InfoForm.value.tel);
  }

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
   this.Listedemande.getdemande().subscribe((ml: any[]) => {
      this.MaListe = ml.find((MaListe : any )=> MaListe.Nom === id);
    })

    this.InfoForm = new FormGroup({
      cni: new FormControl("", [
        Validators.required,
        Validators.minLength(10),
        Validators.maxLength(10),
      ]),
      tel: new FormControl("", [
        Validators.required,
        Validators.minLength(9),
        Validators.maxLength(9),
      ]),
    });
  }
  get cni() { return this.InfoForm.get('cni'); }
  get tel() { return this.InfoForm.get('tel'); }

  public backToList(): void {
    this.router.navigate(['/etudiant','progression']);
  }
}
