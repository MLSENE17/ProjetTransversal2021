import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-compte',
  templateUrl: './compte.component.html',
  styleUrls: ['./compte.component.css']
})
export class CompteComponent implements OnInit {
  public InfoForm :any = [];
  public saveDemande() : void{
    alert("Bien")
    console.log(this.InfoForm.value.type);
    console.log(this.InfoForm.value.poste);
  }

  constructor() { }

  ngOnInit(): void {
    this.InfoForm = new FormGroup({
      type: new FormControl("", [
        Validators.required,
      ]),
      poste: new FormControl("", [
        Validators.required,
      ]),
      email: new FormControl("", [
        Validators.required,
      ]),
      mdp: new FormControl("", [
        Validators.required,
        Validators.minLength(8),
      ])
    });
  }
  get type() { return this.InfoForm.get('type'); }
  get poste() { return this.InfoForm.get('poste'); }
  get email() { return this.InfoForm.get('email'); }
  get mdp() { return this.InfoForm.get('mdp'); }

}
