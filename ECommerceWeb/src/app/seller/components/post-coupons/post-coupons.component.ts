import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { SellersService } from '../../services/sellers.service';

@Component({
  selector: 'app-post-coupons',
  templateUrl: './post-coupons.component.html',
  styleUrls: ['./post-coupons.component.css']
})
export class PostCouponsComponent implements OnInit{

  form!:FormGroup;

  constructor(private fb:FormBuilder,private sellerService : SellersService){}

  ngOnInit(): void {
    this.form = this.fb.group({
      couponName:['',[Validators.required]],
      couponCode:['',[Validators.required]],
      discounts:['',[Validators.required]],
      expirationDate:['',[Validators.required]]
    })
  }

  onSubmit(){
   if(this.form.valid){
    console.log(this.form.value);
    this.sellerService.postCoupon(this.form.value).subscribe(()=>{
      alert('coupon saved successfully');
    })
   }else {
    alert('your form is not valid');
   }
  }

}
