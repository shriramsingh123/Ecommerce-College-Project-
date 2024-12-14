import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { StorageService } from '../../services/storage.service';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  BASE_URL:string = "http://localhost:8080/api/";

  userId :number = (Number(StorageService.getUserId()));

  constructor(private http:HttpClient) { }

  getAllProducts() : any {
    return this.http.get<string>(this.BASE_URL+'product/all',{
      headers:this.createAuthorizationHeader()
    });
  }

  getProductByName(productName : any) : any {
    return this.http.get<string>(this.BASE_URL+`product/name/${productName}`,{
      headers:this.createAuthorizationHeader()
    })
  }

  getProductById(productId : number) : any {
    return this.http.get<string>(this.BASE_URL+`product/${productId}`,{
      headers:this.createAuthorizationHeader()
    });
  }

  getAllCategoryDetails() : any {
    return this.http.get<string>(this.BASE_URL+'category/all',{
      headers:this.createAuthorizationHeader()
    });
  }

  postToCart(productId : any) : Observable<any>{
    return this.http.post<any>(this.BASE_URL+`carts/add/${productId}/${this.userId}`,null,{
      headers:this.createAuthorizationHeader()
    });
  }

  getAllCartsList() : any {
    return this.http.get<any>(this.BASE_URL+`carts/all/${this.userId}`,{
      headers:this.createAuthorizationHeader()
    });
  }

  changeCartProductQuantity(cartId:number,quantity:number){
    return this.http.put<any>(this.BASE_URL+`carts/quantity/${cartId}/${quantity}`,null,{
      headers:this.createAuthorizationHeader()
    })
  }

  deleteCartsById(cartId : number) : any {
    return this.http.delete<any>(this.BASE_URL+`carts/delete/${cartId}`,{
      headers:this.createAuthorizationHeader()
    });
  }

  saveToWishlist(productId : any) : Observable<any>{
    return this.http.post<any>(this.BASE_URL+`wishlist/add/${productId}/${this.userId}`,null,{
      headers:this.createAuthorizationHeader()
    });
  }

  getAllWishListProduct() : any {
    return this.http.get<any>(this.BASE_URL+`wishlist/all/${this.userId}`,{
      headers:this.createAuthorizationHeader()
    });
  }

  deleteWishlistById(wishlistId : number) : any {
    return this.http.delete<any>(this.BASE_URL+`wishlist/delete/${wishlistId}`,{
      headers:this.createAuthorizationHeader()
    });
  }

  getUsersDataById() : any{
    return this.http.get<any>(this.BASE_URL+`auth/profile/${this.userId}`,{
      headers:this.createAuthorizationHeader()
    })
  }

  verifyCoupon(couponCode : any) : any{
    return this.http.get<any>(this.BASE_URL+`coupon/verify/${couponCode}`,{
      headers:this.createAuthorizationHeader()
    })
  }

  placeOrder(data: any, cartId: string, userId: string) : any{
    return this.http.post<any>(this.BASE_URL+`order/place-order/${cartId}/${userId}`,data,{
      headers:this.createAuthorizationHeader()
    })
  }

  getAllOrderList() : any {
    return this.http.get<any>(this.BASE_URL+`order/ordersList/${this.userId}`,{
      headers:this.createAuthorizationHeader()
    })
  }

  createAuthorizationHeader():HttpHeaders{
    let authHeaders: HttpHeaders = new HttpHeaders();
    return authHeaders.set(
      'Authorization',
      'Bearer '+StorageService.getToken()
    );
  }
}
