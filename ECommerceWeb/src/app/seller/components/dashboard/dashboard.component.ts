import { Component, OnInit } from '@angular/core';
import { SellersService } from '../../services/sellers.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit{

  products : any = [];

<<<<<<< HEAD
  images = ['car8.jpg','lamborghini.jpg','nack.jpg'];
=======
  images = ['shoes.avif','diwali.png','photso.webp'];
>>>>>>> c6bd71b (updated cards in frontend)
  imgNum = 0;
  count : number[] = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15];
  four =[1,2,3,4];
  five =[1,2,3,4,5];
  six =[1,2,3,4,5,6];
categories: any;


  slideNext() {
    if(this.imgNum >= 2){
      this.imgNum = 0
    }else{
      this.imgNum++;
    }
  }

  slidePrev() {
    if(this.imgNum <= 0){
      this.imgNum = 2;
    }else{
      this.imgNum--;
    }
  }


constructor(private sellerService:SellersService){}

ngOnInit(): void {
  this.sellerService.getAllProducts().subscribe((res: any) => {
    res.forEach((element : any) => {
      element.processedImg = 'data:image/jpeg;base64,'+element.productImg;
<<<<<<< HEAD
=======
      element.discountPrice = element.price - ((element.price * element.discounts) / 100);
>>>>>>> c6bd71b (updated cards in frontend)
      this.products.push(element);
    });
  })
}

deleteProduct(productId : number) {
  this.sellerService.removeProduct(productId).subscribe(()=>{
    window.location.reload();
    alert("Product Deleted Successfully");
  })
  
}


}
