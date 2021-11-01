import { Component, OnInit } from '@angular/core';
import { EtudiantService } from 'src/app/service/EtudiantService';


@Component({
  selector: 'app-progression',
  templateUrl: './progression.component.html',
  styleUrls: ['./progression.component.css']
})
export class ProgressionComponent implements OnInit {
  demandes:any
  public constructor(private etudiantService:EtudiantService) {
  }
  ngOnInit(): void {
    this.getAllCours();
  }
  getAllCours(){
    const menus= JSON.parse(localStorage.getItem('user')|| '{}')
    this.etudiantService.getCours(menus.email).subscribe(
      (res)=>{
        this.demandes=res;      
      }
    )
  }
  











  

  public secondsLeft = 80
  public saveFile(fileName: string): void {
    // ... save file
  }

  public handleDenial(): void {
      // ... don't save file and quit
  }

  public handleDismiss(dismissMethod: string): void {
    // dismissMethod can be 'cancel', 'overlay', 'close', and 'timer'
    // ... do something
  }
}
