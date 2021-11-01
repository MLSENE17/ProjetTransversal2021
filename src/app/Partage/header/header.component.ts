import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Menu } from 'src/app/model/Menu';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  menu:any;
  constructor(private route:Router) { 
    
  }
  ngOnInit(): void {
    this.getMenus();
  }
  logOut():void{
    localStorage.clear();
    this.route.navigate(['login'])
  }
  getMenus():any{
   const menus:Menu[]= JSON.parse(localStorage.getItem('menu')|| '{}')
   const url  = this.route.url;
    console.log("lamine",url);
    if(menus.length==0){
      localStorage.clear()
      this.route.navigate(['login'])
    }else  if(!(menus.find(e=>url.includes(e.nameRoute.toString())))){
      this.route.navigate([''])
    }
    this.menu=menus;
  }
}
