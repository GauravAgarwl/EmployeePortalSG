import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';


@Injectable()
export class AuthenticationService {
    constructor(private http: HttpClient) { }
    
    attemptAuth(username: string, password: string) {
        const credentials = {username: username, password: password};
        let headers = new HttpHeaders();
        headers = headers.append('noToken', 'noToken');
        console.log('attempAuth ::');
        return this.http.post<any>('http://localhost:8080/token/generate-token', credentials, {headers: headers});
      }

    
}