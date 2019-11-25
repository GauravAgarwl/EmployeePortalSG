import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule }    from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { AppComponent }  from './app.component';
import { routing }        from './app.routing';
import { AlertComponent } from './_directives';
import { AuthGuard } from './_guards';
import { Interceptor,TokenStorage } from './_helpers';
import { AlertService, AuthenticationService, UserService } from './_services';
import { LoginComponent } from './login';
import { RegisterComponent } from './register';;
import { RegisteredUsersComponent } from './registered-users/registered-users.component'
import { ErrorInterceptor } from './_helpers/error.interceptor';
@NgModule({
    imports: [
        BrowserModule,
        ReactiveFormsModule,
        HttpClientModule,
        routing
    ],
    declarations: [
        AppComponent,
        AlertComponent,
        LoginComponent,
        RegisterComponent,
        RegisteredUsersComponent],
    providers: [
        AuthGuard,
        AlertService,
        AuthenticationService,
        UserService,
        TokenStorage,
        { provide: HTTP_INTERCEPTORS, useClass: Interceptor, multi: true },
        { provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true },
    ],
    bootstrap: [AppComponent]
})

export class AppModule { }