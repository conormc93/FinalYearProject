import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateUserComponent } from './create-user/create-user.component';
import { UsersListComponent } from './users-list/users-list.component';
import { SearchUsersComponent } from './search-users/search-users.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { CustomerListComponent } from './customer-list/customer-list.component';
import { SearchCustomersComponent } from './search-customers/search-customers.component';


const routes: Routes = [
    { path: '', redirectTo: 'user', pathMatch: 'full' },
    { path: 'user', component: UsersListComponent },
    { path: 'add', component: CreateUserComponent },
    { path: 'findbycname', component: SearchUsersComponent },
    { path: 'login', component: LoginComponent },
    { path: 'home', component: HomeComponent },
    { path: 'customer', component: CustomerListComponent },
    { path: 'findbyname', component: SearchCustomersComponent },
    { path: '**', redirectTo: '' }
];

export const routing = RouterModule.forRoot(routes);
