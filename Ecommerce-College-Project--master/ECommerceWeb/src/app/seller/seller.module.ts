import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatIconModule} from '@angular/material/icon';

import { SellerRoutingModule } from './seller-routing.module';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { SellerComponent } from './seller.component';
import { PostProductComponent } from './components/post-product/post-product.component';
import { MatCardModule } from '@angular/material/card';
import { PostProductFaqComponent } from './components/post-product-faq/post-product-faq.component';
import { UpdateProductComponent } from './components/update-product/update-product.component';
import { PostCouponsComponent } from './components/post-coupons/post-coupons.component';
import { CouponsComponent } from './components/coupons/coupons.component';
import { OrdersComponent } from './components/orders/orders.component';
import { CategoryComponent } from './components/category/category.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    DashboardComponent,
    SellerComponent,
    PostProductComponent,
    PostProductFaqComponent,
    UpdateProductComponent,
    PostCouponsComponent,
    CouponsComponent,
    OrdersComponent,
    CategoryComponent
  ],
  imports: [
    CommonModule,
    SellerRoutingModule,
    MatCardModule,
    MatIconModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class SellerModule { }
