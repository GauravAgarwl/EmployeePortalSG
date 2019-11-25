import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../_models';
import { Observable } from 'rxjs';
import { TokenStorage } from '../_helpers';

@Injectable()
export class UserService {
    private usersUrl ='http://localhost:8080/employeeDetails/register';
    private useUrl1 ='http://localhost:8080/employeeDetails/getEmp';
   
    constructor(private http: HttpClient,private token: TokenStorage) { }
  
    public getAllEmployees(): Observable<User[]> {
        return this.http.get<User[]>(this.useUrl1);
      }
    
      public registerNewEmployee(user: User) {
        let headers = new HttpHeaders();
        headers = headers.append('noToken', 'noToken');
        return this.http.post<User>(this.usersUrl, user,{headers: headers});
    }

}