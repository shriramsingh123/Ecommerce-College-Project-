import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { CustomerComponent } from './customer.component';
import { CartsComponent } from './components/carts/carts.component';
import { PlaceOrderComponent } from './components/place-order/place-order.component';
import { MyOrderComponent } from './components/my-order/my-order.component';
import { ViewProductDetailComponent } from './components/view-product-detail/view-product-detail.component';
import { ViewWishlistComponent } from './components/view-wishlist/view-wishlist.component';
import { ViewOrderedProductsComponent } from './components/view-ordered-products/view-ordered-products.component';
import { CustomerHomePageComponent } from './components/customer-home-page/customer-home-page.component';
import { ProfileComponent } from './components/profile/profile.component';

const routes: Routes = [
 
  {path:'',component:CustomerComponent},
  {path:'home',component:CustomerHomePageComponent},
  {path:'dashboard/:productName',component:DashboardComponent},
  {path:'carts',component:CartsComponent},
  {path:'wishlist',component:ViewWishlistComponent},
  {path:'profile',component:ProfileComponent},


  {path:'place-order/:cartIds/:couponId',component:PlaceOrderComponent},
  {path:'my-order',component:MyOrderComponent},
  {path:'prod-detail/:productId',component:ViewProductDetailComponent},
  {path:'view-ordered',component:ViewOrderedProductsComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CustomerRoutingModule {

 }
