import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../../services/customer.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-carts',
  templateUrl: './carts.component.html',
  styleUrls: ['./carts.component.css']
})
export class CartsComponent implements OnInit {

  carts: any = [];
  totalPrice: number = 0;
  discounts: number = 0;
  cartIds:any = [];
  couponId = -1;

  constructor(private customerService: CustomerService,
    private router:Router
  ) { }

  ngOnInit(): void {
    this.getAllCartsProducts();
  }

  getAllCartsProducts() {
    this.customerService.getAllCartsList().subscribe((res: any) => {
      console.log(res);
      res.forEach((element: any) => {
        element.processedImg = 'data:image/jpeg;base64,' + element.product.productImg;
        this.carts.push(element);
        this.totalPrice += element.price;
        this.cartIds.push(element.cartId);
      })
    })
  }

  decreaseQuantity(cartId : number,quantity:number) {
    if(quantity >1){
      quantity--;
      this.customerService.changeCartProductQuantity(cartId,quantity).subscribe(()=>{
        window.location.reload();
      })
    }
  }
  increaseQuantity(cartId : number,quantity:number) {
    quantity++;
    this.customerService.changeCartProductQuantity(cartId,quantity).subscribe(()=>{
      window.location.reload();
    })
  }

  addToWishlist(productId: any) {
    this.customerService.saveToWishlist(productId).subscribe(() => {
      alert('Product Added to wishlist');
    })
  }

  removeFromCart(cartId: any) {
    this.customerService.deleteCartsById(cartId).subscribe(() => {
      window.location.reload();
    })
  }

  applyCoupon(f:any){
    this.customerService.verifyCoupon(f.value.couponCode).subscribe((res: any)=>{
      this.discounts=res.discounts;
      this.couponId = res.couponId;
    })

  }



  placeOrder(){
    this.router.navigateByUrl("/customer/place-order/"+this.cartIds+'/'+this.couponId);
  }


}
