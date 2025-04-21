import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { StorageService } from './services/storage.service';
import { UsersService } from './services/users.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{


  title = 'e-commerce';

  isCustomerLoggedIn = StorageService.isSellerLoggedIn();
  isSellerLoggedIn = StorageService.isSellerLoggedIn();
  
  searchSimilarProduct!:FormGroup;

  constructor(private router: Router,
    private fb : FormBuilder
  ){}

  ngOnInit(): void {
    this.router.events.subscribe(() => {
      this.isCustomerLoggedIn = StorageService.isCustomerLoggedIn();
      this.isSellerLoggedIn = StorageService.isSellerLoggedIn();
    })

    this.searchSimilarProduct = this.fb.group({
      productName:['',[Validators.required]]
    })
    
  }

  searchProduct() {
    this.router.navigateByUrl('/seller/dashboard');
  }

  searchSimilarProducts() {
    this.router.navigateByUrl('/customer/dashboard/'+this.searchSimilarProduct.value.productName); 
  }

  logout(){
    StorageService.signOut();
    this.router.navigateByUrl("login");
  }
}
