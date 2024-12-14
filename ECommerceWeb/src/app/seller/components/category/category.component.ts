import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { SellersService } from '../../services/sellers.service';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit{

  form!:FormGroup;
  categoryImg!:File;

  constructor(private fb:FormBuilder,private sellerService:SellersService){}


  ngOnInit(): void {
    this.form = this.fb.group({
      name:['',[Validators.required]],
      desc:['',[Validators.required]]
    })
  }

  onFileSelected(event: any) {
    this.categoryImg = event.target.files[0];
    }

  onSubmit() {
    if(this.form.valid){
      const formData:FormData = new FormData();
      formData.append('categoryImg',this.categoryImg);
      formData.append('categoryName',this.form.get('name')?.value);
      formData.append('categoryDesc',this.form.get('desc')?.value);

      this.sellerService.postCategory(formData).subscribe((res:any)=>{
        console.log(res);
      })
      
      alert('Category Saved in Database Successfully');

    }else{
      console.log("Data is Not valid ");
    }
  }
    
}
