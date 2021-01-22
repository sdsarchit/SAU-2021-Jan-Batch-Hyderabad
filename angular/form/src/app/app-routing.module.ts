import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FormgenerateComponent } from './formgenerate/formgenerate.component';
import { HttpComponent } from './http/http.component';
import { NavigatorComponent } from './navigator/navigator.component';


const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'home'},
  { path: 'home', component: NavigatorComponent},
  { path: 'basicForm', component: FormgenerateComponent },
  { path: 'apiDemo', component: HttpComponent}
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
