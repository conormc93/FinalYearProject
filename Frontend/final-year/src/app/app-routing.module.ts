import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateUserComponent } from './_user/create-user/create-user.component';
import { CreateProductComponent } from './_product/create-product/create-product.component';
import { CreateCustomerComponent } from './_customer/create-customer/create-customer.component';
import { CreateOrderComponent } from './_order/create-order/create-order.component';
import { UsersListComponent } from './_user/users-list/users-list.component';
import { SearchUsersComponent } from './_user/search-users/search-users.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { CustomerListComponent } from './_customer/customer-list/customer-list.component';
import { ProductListComponent } from './_product/product-list/product-list.component';
import { OrderListComponent } from './_order/order-list/order-list.component';
import { SearchCustomersComponent } from './_customer/search-customers/search-customers.component';


const routes: Routes = [
    { path: '', redirectTo: 'login', pathMatch: 'full' },
    { path: 'user', component: UsersListComponent },
    { path: 'add', component: CreateUserComponent },
    { path: 'addProduct', component: CreateProductComponent },
    { path: 'addCustomer', component: CreateCustomerComponent },
    { path: 'addOrder', component: CreateOrderComponent },
    { path: 'findbyname', component: SearchCustomersComponent },
    { path: 'findbycname', component: SearchUsersComponent },
    { path: 'login', component: LoginComponent },
    { path: 'home', component: HomeComponent },
    { path: 'customer', component: CustomerListComponent },
    { path: 'product', component: ProductListComponent },
    { path: 'order', component: OrderListComponent },
    { path: '**', redirectTo: '' }
];

export const routing = RouterModule.forRoot(routes);
