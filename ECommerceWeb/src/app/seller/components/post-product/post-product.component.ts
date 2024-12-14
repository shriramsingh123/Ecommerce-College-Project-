import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { SellersService } from '../../services/sellers.service';

@Component({
  selector: 'app-post-product',
  templateUrl: './post-product.component.html',
  styleUrls: ['./post-product.component.css']
})
export class PostProductComponent implements OnInit{

  form!:FormGroup;
  productImg!:File;

  categories :string[] =[];

  constructor(private fb:FormBuilder,private sellerService:SellersService){}

  ngOnInit(): void {
    this.form = this.fb.group({
      category:['',[Validators.required]],
      shopName:['',[Validators.required]],
      productName:['',[Validators.required]],
      price:['',[Validators.required]],
      discounts:['',[Validators.required]],
      desc:['',[Validators.required]]
    })

    this.getAllCategoriesName();

  }

  getAllCategoriesName(){
    this.sellerService.getAllCategoryName().subscribe((res : any)=>{
      this.categories = res;
    })
  }

  onSelectedFile(event: any) {
    this.productImg = event.target.files[0];
    }
  onSubmit(){
    if(this.form.valid){
      const formData:FormData = new FormData();
      formData.append('productImg',this.productImg);
      formData.append('category',this.form.get('category')?.value);
      formData.append('shopName',this.form.get('shopName')?.value);
      formData.append('productName',this.form.get('productName')?.value);
      formData.append('price',this.form.get('price')?.value);
      formData.append('discounts',this.form.get('discounts')?.value);
      formData.append('desc',this.form.get('desc')?.value);

      this.sellerService.postProduct(formData).subscribe(()=>{
        alert("Product saved Successfully");
      })
    }else{
      console.log("Your Form is not valid ");
    }
  }
}
