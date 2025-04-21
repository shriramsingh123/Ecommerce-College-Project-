import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UsersService } from '../services/users.service';
import { StorageService } from '../services/storage.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{

  form!: FormGroup;

  constructor(private fb:FormBuilder,
    private userService:UsersService,
    private storageService:StorageService,
  private router:Router){}

  ngOnInit(): void {
    this.form = this.fb.group({
      username:['',[Validators.required]],
      password:['',[Validators.required]]
    })
  }
                                                                                                  
  OnSubmit(){
    this.userService.login(this.form.value).subscribe((res : any)=>{
      console.log(res);
      if(res.userId != null){
        const user ={
          id : res.userId,
          role:res.role
        }
        this.storageService.saveUser(user);
        this.storageService.saveToken(res.jwt);
      }

      if(StorageService.isSellerLoggedIn()){
        this.router.navigateByUrl('seller/dashboard');
      }else if(StorageService.isCustomerLoggedIn()){
        this.router.navigateByUrl('customer/home');
      }else{
        alert("Wrong username or password");
      }
     
    })
  }
}