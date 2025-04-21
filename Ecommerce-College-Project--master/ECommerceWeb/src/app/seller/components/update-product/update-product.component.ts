import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { SellersService } from '../../services/sellers.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-update-product',
  templateUrl: './update-product.component.html',
  styleUrls: ['./update-product.component.css']
})
export class UpdateProductComponent {

  
  form!:FormGroup;
  productImg!:File;
  

  categories :string[] =[];
  productId:any;

  constructor(private fb:FormBuilder,private sellerService:SellersService,
    private route : ActivatedRoute
  ){}

  ngOnInit(): void {
    this.productId = this.route.snapshot.paramMap.get("productId");
    this.getProductDetailsById();
    this.getAllCategoriesName();


    this.form = this.fb.group({
      category:['',[Validators.required]],
      shopName:['',[Validators.required]],
      productName:['',[Validators.required]],
      price:['',[Validators.required]],
      discounts:['',[Validators.required]],
      desc:['',[Validators.required]]
    })
  }

  getAllCategoriesName(){
    this.sellerService.getAllCategoryName().subscribe((res : any)=>{
      this.categories = res;
    })
  }

  getProductDetailsById(){
    this.sellerService.getProductById(this.productId).subscribe((res: any)=>{
      this.form.patchValue(res);
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
      formData.append('productId',this.productId);
      
      this.sellerService.updateProduct(formData).subscribe(()=>{
        alert("Product Updated Successfully");
      })

    }else{
      console.log("Your Form is not valid ");
    }

  }

}
