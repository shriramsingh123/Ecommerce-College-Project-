import { Component } from '@angular/core';
import { CustomerService } from '../../services/customer.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent {


  images = ['car8.jpg', 'lamborghini.jpg', 'nack.jpg'];
  imgNum = 0;
  four = [1, 2, 3, 4];
  five = [1, 2, 3, 4, 5];
  six = [1, 2, 3, 4, 5, 6];

  products: any = [];
  categories: any = [];


  slideNext() {
    if (this.imgNum >= 2) {
      this.imgNum = 0
    } else {
      this.imgNum++;
    }
  }

  slidePrev() {
    if (this.imgNum <= 0) {
      this.imgNum = 2;
    } else {
      this.imgNum--;
    }
  }

  constructor(private customerService: CustomerService,
    private route:ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.getSimilarProducts(this.route.snapshot.paramMap.get("productName"));
    this.getAllCategories();
  }

  getSimilarProducts(productName:any) {
    this.customerService.getProductByName(productName).subscribe((res: any) => {
      res.forEach((element: any) => {
        element.processedImg = 'data:image/jpeg;base64,' + element.productImg;
        element.discountPrice = element.price - ((element.price * element.discounts) / 100);
        this.products.push(element);
      });
    })
  }

  getAllCategories() {
    this.customerService.getAllCategoryDetails().subscribe((res: any) => {
      res.forEach((element: any) => {
        element.processedImg = 'data:image/jpeg;base64,' + element.categoryImg;
        this.categories.push(element);
      });
    })
  }

  addToCart(productId: any) {
    this.customerService.postToCart(productId).subscribe(()=>{
      alert('Product Added to Cart Successfully');
    })
  }
}
