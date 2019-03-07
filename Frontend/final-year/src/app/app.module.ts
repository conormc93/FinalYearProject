import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { CreateUserComponent } from './_user/create-user/create-user.component';
import { UserDetailsComponent } from './_user/user-details/user-details.component';
import { UsersListComponent } from './_user/users-list/users-list.component';
import { SearchUsersComponent } from './_user/search-users/search-users.component';
import { routing } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { CustomerListComponent } from './_customer/customer-list/customer-list.component';
import { CustomerDetailsComponent } from './_customer/customer-details/customer-details.component';
import { SearchCustomersComponent } from './_customer/search-customers/search-customers.component';
import { ProductListComponent } from './_product/product-list/product-list.component';
import { ProductDetailsComponent } from './_product/product-details/product-details.component';
import { CreateProductComponent } from './_product/create-product/create-product.component';
import { CreateOrderComponent } from './_order/create-order/create-order.component';
import { OrderListComponent } from './_order/order-list/order-list.component';
import { OrderDetailsComponent } from './_order/order-details/order-details.component';
import { CreateCustomerComponent } from './_customer/create-customer/create-customer.component';


@NgModule({
  declarations: [
    AppComponent,
    CreateUserComponent,
    CreateOrderComponent,
    CreateCustomerComponent,
    OrderListComponent,
    OrderDetailsComponent,
    UserDetailsComponent,
    UsersListComponent,
    SearchUsersComponent,
    LoginComponent,
    HomeComponent,
    CustomerListComponent,
    CustomerDetailsComponent,
    SearchCustomersComponent,
    ProductListComponent,
    ProductDetailsComponent,
    CreateProductComponent,
    CreateCustomerComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    routing,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
