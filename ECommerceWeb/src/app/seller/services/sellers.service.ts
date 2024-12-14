import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { StorageService } from '../../services/storage.service';

@Injectable({
  providedIn: 'root'
})
export class SellersService{

  BASE_URL:string = "http://localhost:8080/api/";

  constructor(private http:HttpClient) { }

  postCategory(data:any) : Observable<any>{
    return this.http.post<any>(this.BASE_URL+'category/register',data,{
      headers:this.createAuthorizationHeader()
    });
  }

  getAllCategoryName() : any {
    return this.http.get<string>(this.BASE_URL+'category/name',{
      headers:this.createAuthorizationHeader()
    });
  }

  postProduct(data:any) : Observable<any> {
    return this.http.post<any>(this.BASE_URL+'product/add',data,{
      headers:this.createAuthorizationHeader()
    });
  }

  getProductById(productId : number) : any {
    return this.http.get<string>(this.BASE_URL+`product/${productId}`,{
      headers:this.createAuthorizationHeader()
    });
  }

  getAllProducts() : any {
    return this.http.get<string>(this.BASE_URL+'product/all',{
      headers:this.createAuthorizationHeader()
    });
  }

  removeProduct(productId:any) : Observable<any> {
    return this.http.delete<any>(this.BASE_URL+`product/remove/${productId}`,{
      headers:this.createAuthorizationHeader()
    });
  }

  updateProduct(data:any) : Observable<any> {
    return this.http.put<any>(this.BASE_URL+'product/update',data,{
      headers:this.createAuthorizationHeader()
    });
  }


  postFAQ(data : any,productId : any) : Observable<any>{
    return this.http.post<any>(this.BASE_URL+`faq/add/${productId}`,data,{
      headers:this.createAuthorizationHeader()
    });
  }

  postCoupon(data:any) : Observable<any>{
    return this.http.post<any>(this.BASE_URL+'coupon/add',data,{
      headers:this.createAuthorizationHeader()
    });
  }

  getAllCoupons() : any {
    return this.http.get<any>(this.BASE_URL+'coupon/all',{
      headers:this.createAuthorizationHeader()
    });
  }

  createAuthorizationHeader():HttpHeaders{
    let authHeaders: HttpHeaders = new HttpHeaders();
    return authHeaders.set(
      'Authorization',
      'Bearer '+StorageService.getToken()
    );
  }

}
