import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { DiplomeService } from 'src/app/service/DiplomeService';

@Component({
  selector: 'app-statistique',
  templateUrl: './statistique.component.html',
  styleUrls: ['./statistique.component.css']
})
export class StatistiqueComponent implements OnInit {
  total:any
  constructor(private title:Title,
    private diplomeService:DiplomeService) {
    title.setTitle("Admin")
   }

  ngOnInit(): void {
    this.getTotal()
  }
  getTotal(){
    this.diplomeService.getTotal().subscribe(
      (res)=>{
           this.total=res
           console.log(this.total);
           
      },
      
    )
  }

}
