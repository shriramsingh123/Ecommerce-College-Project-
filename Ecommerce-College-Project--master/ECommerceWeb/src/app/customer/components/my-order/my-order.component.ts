import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../../services/customer.service';
import { elementAt } from 'rxjs';

@Component({
  selector: 'app-my-order',
  templateUrl: './my-order.component.html',
  styleUrls: ['./my-order.component.css']
})
export class MyOrderComponent implements OnInit{

  myorders = [];

  constructor(private customerService : CustomerService){}

  ngOnInit(): void {
    this.getAllOrdersList();
  }

  getAllOrdersList() {
    this.customerService.getAllOrderList().subscribe((res: any) => {
      res.forEach((element: any) => {
        if (element.images && element.images.length > 0) {
          element.processedImages = [];
          element.images.forEach((image: any) => {
            element.processedImages.push('data:image/jpeg;base64,' + image);
          });
        }
        this.myorders.push(element);
      });
    });
  }



}
