import { AfterViewInit, Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, NgForm, Validators } from '@angular/forms';
import { GValidator } from '../../Partage/Validateurs/gvalidator';


@Component({
  selector: 'app-services',
  templateUrl: './services.component.html',
  styleUrls: ['./services.component.css']
})
export class ServicesComponent implements OnInit, AfterViewInit {

  public formErrors : {[key :string] : string} = {}

  private validationsMessages : {[key :string] : {[key :string] : string}} = {
    serviceName : {
      required  : "Renseignez le nom de la demande"
    }
  }
 //private val : GValidator;
  
  public serviceForm :any = [];
  constructor(private fb : FormBuilder) {
   // this.val = new GValidator(this.validationsMessages)
   }

  ngOnInit(): void {
    this.serviceForm = this.fb.group({
      serviceName : ["",Validators.required],
    })
   
  }
ngAfterViewInit(){
  //this.formErrors = this.val.createErrorMessage(this.serviceForm)
}

  public saveDemande() : void{
    alert("Bien")
    console.log(this.serviceForm.value.serviceName);
  }

}
