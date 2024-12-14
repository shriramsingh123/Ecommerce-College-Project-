import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SignupComponent } from './signup/signup.component';
import { HomepageComponent } from './about-dev/homepage/homepage.component';
import { LoginComponent } from './login/login.component';
import { AppComponent } from './app.component';
import { DocumentationComponent } from './documentation/documentation.component';

const routes: Routes = [
  {path:'',component:AppComponent},
  {path:'about',component:HomepageComponent},
  {path:'login',component:LoginComponent},
  {path:'signup',component:SignupComponent},
  {path:'documentation',component:DocumentationComponent},
  {path:'customer', loadChildren:() => import('./customer/customer.module').then(m=>m.CustomerModule)},
   {path:'seller',loadChildren:() => import('./seller/seller.module').then(m=>m.SellerModule)}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
