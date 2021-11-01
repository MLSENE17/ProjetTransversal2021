import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css']
})
export class DetailsComponent implements OnInit {

  InfoForm = new FormGroup({
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

  constructor(
  ) { }
  get f() { return this.InfoForm.controls ; }

  ngOnInit(): void {
   
  }
  
}
