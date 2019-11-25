import { Injectable } from '@angular/core';
import { Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { TokenStorage } from '../_helpers';

@Injectable()
export class AuthGuard implements CanActivate {

    constructor(private router: Router,private token : TokenStorage) { }

    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        if(this.token.getToken()!=null) {
        return true;
        }

        this.router.navigate(['']);
        return false;
    }
}
