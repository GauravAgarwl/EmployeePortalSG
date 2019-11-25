import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login';
import { RegisterComponent } from './register';
import { AuthGuard } from './_guards';
import { RegisteredUsersComponent } from './registered-users';

const appRoutes: Routes = [
    { path: '', component: LoginComponent},
    { path: 'viewAllUsers', component: RegisteredUsersComponent, canActivate: [AuthGuard] },
    { path: 'register', component: RegisterComponent },
    { path: '**', redirectTo: '' }
];

export const routing = RouterModule.forRoot(appRoutes);