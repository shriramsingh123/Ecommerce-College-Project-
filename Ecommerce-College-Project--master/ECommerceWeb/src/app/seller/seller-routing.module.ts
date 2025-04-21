import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SellerComponent } from './seller.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { PostProductComponent } from './components/post-product/post-product.component';
import { PostCouponsComponent } from './components/post-coupons/post-coupons.component';
import { CouponsComponent } from './components/coupons/coupons.component';
import { PostProductFaqComponent } from './components/post-product-faq/post-product-faq.component';
import { OrdersComponent } from './components/orders/orders.component';
import { UpdateProductComponent } from './components/update-product/update-product.component';
import { CategoryComponent } from './components/category/category.component';

const routes: Routes = [
  {path:'',component:SellerComponent},
  {path:'dashboard',component:DashboardComponent},
  {path:'post-product',component:PostProductComponent},
  {path:'post-coupon',component:PostCouponsComponent},
  {path:'coupons',component:CouponsComponent},
  {path:'category',component:CategoryComponent},
  {path:'update-product/:productId',component:UpdateProductComponent},
  {path:'faq/:productId',component:PostProductFaqComponent},

  /* Temp*/
  {path:'orders',component:OrdersComponent},
 
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SellerRoutingModule { }
