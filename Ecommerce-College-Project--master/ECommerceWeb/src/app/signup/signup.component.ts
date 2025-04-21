import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UsersService } from '../services/users.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  roles = ["CUSTOMER", "SELLER"];
  genders = ["MALE", "FEMALE", "TRANSGENDER", "PREFER NOT TO SAY"];
  countries = ["INDIA"];
  provinces = ["ASSAM","BIHAR","CHHATISGARH","JAMMU & KASHMIR","DELHI","MAHARASTRA"];

  form!: FormGroup;
  profileImage!:File;

  constructor(private fb: FormBuilder,
    private router : Router,
    private usersService : UsersService
  ) {}



  ngOnInit(): void {
    this.form = this.fb.group({
      firstName: ['', [Validators.required]],
      lastName: ['', [Validators.required]],
      gender: ['', [Validators.required]],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.min(5), Validators.max(8)]],
      roles: ['', [Validators.required]],
      mobileNo: ['', [Validators.required]],
      nationality: ['', [Validators.required]],
      province: ['', [Validators.required]]
    })
  }

  get firstName() { return this.form.get('firstName'); }
  get lastName() { return this.form.get('lastName'); }
  get email() { return this.form.get('email'); }
  get password() { return this.form.get('password'); }
  get mobileNo() { return this.form.get('phoneNo'); }

  onFileSelected(event: any) {
    this.profileImage = event.target.files[0];
  }


  onSubmit() {
    if (this.form.valid) {
      const formData:FormData = new FormData;
      formData.append('profileImg',this.profileImage);
      formData.append('firstName',this.form.get('firstName')?.value);
      formData.append('lastName',this.form.get('lastName')?.value);
      formData.append('gender',this.form.get('gender')?.value);
      formData.append('email',this.form.get('email')?.value);
      formData.append('password',this.form.get('password')?.value);
      formData.append('roles',this.form.get('roles')?.value);
      formData.append('mobileNo',this.form.get('mobileNo')?.value);
      formData.append('nationality',this.form.get('nationality')?.value);
      formData.append('province',this.form.get('province')?.value);

      this.usersService.saveUser(formData).subscribe(
        response => {
          console.log(response);
        }
      )
      this.router.navigateByUrl("/login");
    }else{
      console.log("Not Submitted Getting Error");
    }
  }

}
