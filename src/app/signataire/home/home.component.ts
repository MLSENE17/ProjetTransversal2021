import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Title } from '@angular/platform-browser';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  constructor(private title:Title) { this.title.setTitle("Signataire|Reception")}

  ngOnInit(): void {
  }
  onUpdate(id:any){
    console.log(id)
  }
  numEtudiant(even:Event){
     const input =(even.target as HTMLInputElement).value;
     if(input.length>6){
       console.log(input)
     }
  }
  getAllMessage():void{
    console.log("lamine")
  }
  getStatus(event:Event){
    const select = (event.target as HTMLSelectElement).value;
    if(select){
      console.log(select);
    }
  }
}
