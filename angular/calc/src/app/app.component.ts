import { Component } from '@angular/core';
import { CalcService } from './services/calc.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'calc';
  constructor(private calc: CalcService){}
  result = 0;
  a = 0;
  b = 0;
  // tslint:disable-next-line:typedef
  addition()
  {
    this.result = this.calc.add(this.a, this.b);
  }
  // tslint:disable-next-line:typedef
  subtraction()
  {
    this.result = this.calc.subtract(this.a, this.b);
  }
  // tslint:disable-next-line:typedef
  multiplication()
  {
    this.result = this.calc.mul(this.a, this.b);
  }
  // tslint:disable-next-line:typedef
  division()
  {
    this.result = this.calc.div(this.a, this.b);
  }
}
