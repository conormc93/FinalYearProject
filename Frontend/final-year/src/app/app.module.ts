import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { CreateUserComponent } from './create-user/create-user.component';
import { UserDetailsComponent } from './user-details/user-details.component';
import { UsersListComponent } from './users-list/users-list.component';
import { SearchUsersComponent } from './search-users/search-users.component';
import { routing } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { CustomerListComponent } from './customer-list/customer-list.component';
import { CustomerDetailsComponent } from './customer-details/customer-details.component';
import { SearchCustomersComponent } from './search-customers/search-customers.component';
import { ProductListComponent } from './product-list/product-list.component';
import { ProductDetailsComponent } from './product-details/product-details.component';
import { CreateProductComponent } from './create-product/create-product.component';
import { CreateOrderComponent } from './create-order/create-order.component';
import { OrderListComponent } from './order-list/order-list.component';
import { OrderDetailsComponent } from './order-details/order-details.component';


@NgModule({
  declarations: [
    AppComponent,
    CreateUserComponent,
    CreateOrderComponent,
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
    CreateProductComponent
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
