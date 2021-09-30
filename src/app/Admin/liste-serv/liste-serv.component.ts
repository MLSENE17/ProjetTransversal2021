import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-liste-serv',
  templateUrl: './liste-serv.component.html',
  styleUrls: ['./liste-serv.component.css']
})
export class ListeServComponent implements OnInit {
  constructor( private fb : FormBuilder) { }
  public InfoForm :any = [];

  ngOnInit() {
    this.InfoForm = new FormGroup({
      name: new FormControl("", [
        Validators.required,
      ]),
    });
  }
  get name() { return this.InfoForm.get('name'); }

  public saveDemande() : void{
    alert("Bien")
    console.log(this.InfoForm.value.name);
    this.name()
  }

}
