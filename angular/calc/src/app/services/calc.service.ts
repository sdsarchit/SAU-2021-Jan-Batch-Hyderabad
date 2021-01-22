import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CalcService {

  constructor() { }
  // tslint:disable-next-line: typedef
  add(number1: number, number2: number){
  return number1 + number2;
  }
  // tslint:disable-next-line: typedef
  subtract(number1: number, number2: number){
  return number2 - number1;
  }
  // tslint:disable-next-line: typedef
  mul(number1: number, number2: number){
  return number2 * number1;
  }
  // tslint:disable-next-line: typedef
  div(number1: number, number2: number){
  return number2 / number1;
  }
}
