import { Component, OnInit } from '@angular/core';
import { SellersService } from '../../services/sellers.service';

@Component({
  selector: 'app-coupons',
  templateUrl: './coupons.component.html',
  styleUrls: ['./coupons.component.css']
})
export class CouponsComponent implements OnInit {

  coupons : any;

  constructor(private sellerService : SellersService){}

  ngOnInit(): void {
    this.sellerService.getAllCoupons().subscribe((res: any) => {
      this.coupons = res;
    })
  }

}
