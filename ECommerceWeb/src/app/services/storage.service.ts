import { Injectable } from '@angular/core';

const TOKEN  = 'token';
const USER  = 'ecom-user';

@Injectable({
  providedIn: 'root'
})


export class StorageService {

  constructor() { }

  public saveToken(token : string) : void{
    
    window.localStorage.removeItem(TOKEN);
    window.localStorage.setItem(TOKEN,token);
}

public saveUser(user: any): void {
  window.localStorage.removeItem(USER);  
  window.localStorage.setItem(USER, JSON.stringify(user));
}

static getToken() : any {
  return window.localStorage.getItem(TOKEN);
}


static getUser() : any {
  return JSON.parse(localStorage.getItem(USER) as string);
}

static getUserId() : string {
  const user = this.getUser();
  if(user == null){
    return '';
  }
  return user.id;
}

static getUserRole() : string {
  const user = this.getUser();
  if(user == null){
    return '';
  }
  return user.role;
}

static isSellerLoggedIn() : boolean {
  if(this.getToken() === null){
    return false;
  }
  const role: string = this.getUserRole();
  return role == 'SELLER';
}

static isCustomerLoggedIn() : boolean {
  if(this.getToken() == null) {
    return false;
  }
   const role : string = this.getUserRole();
   return role == 'CUSTOMER';
}

static signOut() : void {
  window.localStorage.removeItem(TOKEN);
  window.localStorage.removeItem(USER);
}
}
