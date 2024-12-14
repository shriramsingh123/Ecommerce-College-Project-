import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router} from '@angular/router';
import { CustomerService } from '../../services/customer.service';

@Component({
  selector: 'app-view-product-detail',
  templateUrl: './view-product-detail.component.html',
  styleUrls: ['./view-product-detail.component.css']
})
export class ViewProductDetailComponent implements OnInit{

  productId:any;
  productDetail:any;

  constructor(private customerService:CustomerService,
    private route:ActivatedRoute){}

  ngOnInit(): void {
    this.productId = this.route.snapshot.paramMap.get("productId");
      this.getProductDetailsById();
  }

  getProductDetailsById(){
    this.customerService.getProductById(this.productId).subscribe((res: any)=>{
      res.processedImg = 'data:image/jpeg;base64,' + res.productImg;
      res.discountPrice = res.price - ((res.price * res.discounts) / 100);
      this.productDetail = res;
    })
  }

  addToWishlist(productId : any){
    this.customerService.saveToWishlist(productId).subscribe(()=>{
      alert('Product Added to wishlist');
    })
  }

}
