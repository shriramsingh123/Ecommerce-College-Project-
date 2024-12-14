import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../../services/customer.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit{
 
  profileData :any;

  constructor(private customerService:CustomerService){}


  ngOnInit(): void {
    this.getUserDetail();
  }

  getUserDetail(){
    this.customerService.getUsersDataById().subscribe((res: any)=>{
      res.profileImg = 'data:image/jpeg;base64,' + res.profileImg;
        this.profileData = res;
    })
  }

}
