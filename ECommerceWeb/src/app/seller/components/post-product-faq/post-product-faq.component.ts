import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { SellersService } from '../../services/sellers.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-post-product-faq',
  templateUrl: './post-product-faq.component.html',
  styleUrls: ['./post-product-faq.component.css']
})
export class PostProductFaqComponent implements OnInit {
 
  form!:FormGroup;
  productId : any;
  
  constructor(private fb:FormBuilder,private sellerService : SellersService,
    private route : ActivatedRoute
  ){}
  ngOnInit(): void {
    this.productId = this.route.snapshot.paramMap.get("productId");
    this.form = this.fb.group({
      question:['',[Validators.required]],
      answer:['',[Validators.required]]
    })
  }

  onSubmit(){
    if(this.form.valid){

      this.sellerService.postFAQ(this.form.value,this.productId).subscribe((res) =>{
        alert('FAQ added successfully'+res);
        console.log(this.productId);
      })
    }else{
      console.log("Your FAQ is not valid");
    }
  }

}
