import { Component, OnInit } from '@angular/core';
import { SwalPortalTargets } from '@sweetalert2/ngx-sweetalert2';
import { ListeService } from './liste.service';
import {IProg} from './listeModel'


@Component({
  selector: 'app-progression',
  templateUrl: './progression.component.html',
  styleUrls: ['./progression.component.css']
})
export class ProgressionComponent implements OnInit {
  public constructor(public readonly swalTargets: SwalPortalTargets,
    private Listedemande: ListeService) {
  }

  public MaListe : IProg[] = [];
  public errorMsg: string ="";

  ngOnInit(): void {

    this.Listedemande.getdemande().subscribe({
      next: MaListe => {
        this.MaListe = MaListe;
      },
      error: err => this.errorMsg = err
    });

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
