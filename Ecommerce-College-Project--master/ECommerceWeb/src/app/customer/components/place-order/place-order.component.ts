import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../../services/customer.service';
import { StorageService } from 'src/app/services/storage.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-place-order',
  templateUrl: './place-order.component.html',
  styleUrls: ['./place-order.component.css']
})
export class PlaceOrderComponent implements OnInit{

  userId = StorageService.getUserId();
  form :FormGroup;
  cartIds:number[];
  
  constructor(private customerService:CustomerService,
    private fb:FormBuilder,
    private route:ActivatedRoute
  ){}

  ngOnInit(): void {

    this.form = this.fb.group({
      email:['',[Validators.required]],
      country:['',[Validators.required]],
      firstName:['',[Validators.required]],
      lastName:['',[Validators.required]],
      street:['',[Validators.required]],
      postalCode:['',[Validators.required]],
      city:['',[Validators.required]],
      province:['',[Validators.required]],
      mobileNo:['',[Validators.required]],
      payment:['',[Validators.required]]
    })
    
  }

  onSubmit(){

    const cartId =  this.route.snapshot.paramMap.get('cartIds');
    const couponId =  this.route.snapshot.paramMap.get('couponId');
    

    const formData:FormData = new FormData();
    formData.append('email',this.form.get('email')?.value);
    formData.append('country',this.form.get('country')?.value);
    formData.append('firstName',this.form.get('firstName')?.value);
    formData.append('lastName',this.form.get('lastName')?.value);
    formData.append('street',this.form.get('street')?.value);
    formData.append('postalCode',this.form.get('postalCode')?.value);
    formData.append('city',this.form.get('city')?.value);
    formData.append('province',this.form.get('province')?.value);
    formData.append('mobileNo',this.form.get('mobileNo')?.value);
    formData.append('payment',this.form.get('payment')?.value);
    formData.append('couponId',couponId);
    
    this.customerService.placeOrder(formData,cartId,this.userId).subscribe((res : any)=>{
        alert('order placed Successfully');
    })
  }

}
