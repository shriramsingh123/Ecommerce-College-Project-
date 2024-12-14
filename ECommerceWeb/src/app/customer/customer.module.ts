import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatButtonModule} from '@angular/material/button';
import { MatCardModule} from '@angular/material/card';
import { CustomerComponent } from './customer.component';
import { CustomerRoutingModule } from './customer-routing.module';
import { CartsComponent } from './components/carts/carts.component';
import { MyOrderComponent } from './components/my-order/my-order.component';
import { PlaceOrderComponent } from './components/place-order/place-order.component';


import {MatFormFieldModule} from '@angular/material/form-field';
import {FormsModule,ReactiveFormsModule} from '@angular/forms';
import {MatInputModule} from '@angular/material/input';
import {MatSelectModule} from '@angular/material/select';
import { ViewProductDetailComponent } from './components/view-product-detail/view-product-detail.component';
import { ViewWishlistComponent } from './components/view-wishlist/view-wishlist.component';
import { ViewOrderedProductsComponent } from './components/view-ordered-products/view-ordered-products.component';
import { ReviewedOrderedProductComponent } from './components/reviewed-ordered-product/reviewed-ordered-product.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { CustomerHomePageComponent } from './components/customer-home-page/customer-home-page.component';
import { ProfileComponent } from './components/profile/profile.component';




@NgModule({
  declarations: [
    DashboardComponent,
    CustomerComponent,
    CartsComponent,
    MyOrderComponent,
    PlaceOrderComponent,
    ViewProductDetailComponent,
    ViewWishlistComponent,
    ViewOrderedProductsComponent,
    ReviewedOrderedProductComponent,
    CustomerHomePageComponent,
    ProfileComponent
  ],
  imports: [
    CommonModule,
    MatButtonModule,
    MatCardModule,
    CustomerRoutingModule,
    MatFormFieldModule,
    FormsModule,
    ReactiveFormsModule,
    MatInputModule,
    MatSelectModule
    
  ]
})
export class CustomerModule { }
