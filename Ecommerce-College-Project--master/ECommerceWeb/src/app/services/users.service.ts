import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UsersService {

  BASE_URL : string = "http://localhost:8080/api/auth";

  constructor(private http : HttpClient) { }

  saveUser(users : any) : Observable<any>{
    return this.http.post(`${this.BASE_URL}/register`,users).pipe(
      catchError((error)=> {
        console.log("Your data not saved getting error "+error);
        throw error;
      })
    )
  }

  login(data : any) : Observable<any>{
    return this.http.post<any>(`${this.BASE_URL}/generateToken`,data);
  }
}
