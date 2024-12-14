import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../../services/customer.service';


@Component({
  selector: 'app-view-wishlist',
  templateUrl: './view-wishlist.component.html',
  styleUrls: ['./view-wishlist.component.css']
})
export class ViewWishlistComponent implements OnInit{

  wishlists : any =[];

  constructor(private customerService:CustomerService){}

 

  ngOnInit(): void {
    this.getAllWishlistProducts();
  }

  getAllWishlistProducts(){
    this.customerService.getAllWishListProduct().subscribe((res: any)=>{
      res.forEach((element : any)=>{
        element.processedImg = 'data:image/jpeg;base64,' + element.productDtoResponse.productImg;
        this.wishlists.push(element);
      })
    })
  }

  removeFromWishList(wishlistId : any) {
    this.customerService.deleteWishlistById(wishlistId).subscribe(()=>{
      window.location.reload();
    })
  }

  addToCart(productId: any) {
    this.customerService.postToCart(productId).subscribe(()=>{
      alert('Product Added to Cart Successfully');
    })
  }

}
