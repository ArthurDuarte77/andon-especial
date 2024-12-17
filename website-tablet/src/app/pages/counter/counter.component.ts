import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Route, Router } from '@angular/router';

@Component({
  selector: 'app-counter',
  templateUrl: './counter.component.html',
  styleUrls: ['./counter.component.scss'],
})
export class CounterComponent implements OnInit {
  constructor(private route: ActivatedRoute, private location: Router) {}

  ngOnInit() {
    this.route.params.subscribe((params) => {
      var param = params['name'][0].toLowerCase();
      if (param == 'p') {
        this.location.navigate([`/inversorl1/${params['name'].substring(1)}`]);
      } else if (param == 'b') {
        this.location.navigate([`/inversorl2/${params['name'].substring(1)}`]);
      }else if(param == "a"){
        this.location.navigate([`/amplificador/${params['name'].substring(1)}`]);
      }else if(param == "c"){
        this.location.navigate([`/amplificadorl2/${params['name'].substring(1)}`]);
      }else if(param == "t"){
        this.location.navigate([`/controle/${params['name'].substring(1)}`]);
      }
    });
  }
}
