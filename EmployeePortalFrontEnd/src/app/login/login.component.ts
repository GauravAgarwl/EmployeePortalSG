import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AlertService, AuthenticationService } from '../_services';
import { TokenStorage } from '../_helpers/token.storage';
import { first } from 'rxjs/operators';

@Component({templateUrl: 'login.component.html'})
export class LoginComponent {

    loginForm: FormGroup;
    loading = false;
    submitted = false;
    returnUrl: string;
    constructor(
        private formBuilder: FormBuilder,
        private route: ActivatedRoute,
        private router: Router,
        private authenticationService: AuthenticationService,
        private alertService: AlertService,
        private token: TokenStorage) {}

        username: string;
        password: string;
        ngOnInit() {
            this.loginForm = this.formBuilder.group({
                username: ['', Validators.required],
                password: ['', Validators.required]
            });
        }

        get f() { return this.loginForm.controls; }

        onSubmit() {
            this.submitted = true;
    
            if (this.loginForm.invalid) {
                return;
            }
            this.authenticationService.attemptAuth(this.f.username.value, this.f.password.value).pipe(first()).subscribe(
                data => {
                  this.token.saveToken(data.result.token);
                  this.router.navigate(['/viewAllUsers']);
                },
                        error => {
                             this.alertService.error(error);
                        }
              );
        }
              
   
}
