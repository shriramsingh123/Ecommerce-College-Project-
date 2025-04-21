import { Component, OnInit } from '@angular/core';
import { SellersService } from '../../../seller/services/sellers.service';
import { CustomerService } from '../../services/customer.service';

@Component({
  selector: 'app-customer-home-page',
  templateUrl: './customer-home-page.component.html',
  styleUrls: ['./customer-home-page.component.css']
})
export class CustomerHomePageComponent implements OnInit{

  advertisement = ['shoes.avif','diwali.png','photso.webp'];
  discountedDeals = ['discount1.webp','discount2.webp','discount3.webp'];
  beautyandmakupAdvertisement = ['makup1.webp','makup2.webp','makup3.jpg'];
  blockbasterproductimg = ['car8.jpg','lamborghini.jpg','nack.jpg','ring.jpg'];
  imgNum = 0;
  four =[0,1,2,3];
  five =[1,2,3,4,5];
  products: any =[];
  categories: any = [];



  slideFirstNext() {
    if(this.imgNum >= 2)this.imgNum = 0
    else this.imgNum++;
  }
  slideFirstPrev() {
    if(this.imgNum <= 0) this.imgNum = 2;
    else this.imgNum--;
  }

  slideSecondNext() {
    if(this.imgNum >= 2)this.imgNum = 0
    else this.imgNum++;
  }
  slideSecondPrev() {
    if(this.imgNum <= 0) this.imgNum = 2;
    else this.imgNum--;
  }

  slideThirdNext() {
    if(this.imgNum >= 2)this.imgNum = 0
    else this.imgNum++;
  }
  slideThirdPrev() {
    if(this.imgNum <= 0) this.imgNum = 2;
    else this.imgNum--;
  }

  constructor(private customerService:CustomerService){}

  ngOnInit(): void {
    this.customerService.getAllProducts().subscribe((res: any) => {
      res.forEach((element : any) => {
        element.processedImg = 'data:image/jpeg;base64,'+element.productImg;
        this.products.push(element);
      });
    })

    this.getAllCategories();
  }

  getAllCategories() {
    this.customerService.getAllCategoryDetails().subscribe((res: any) => {
      res.forEach((element: any) => {
        element.processedImg = 'data:image/jpeg;base64,' + element.categoryImg;
        this.categories.push(element);
      });
    })
  }

  backToTop(){
    window.scrollTo(0,0);
  }


}
