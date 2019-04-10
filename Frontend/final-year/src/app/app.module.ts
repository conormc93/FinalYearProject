import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { UserComponent } from './user/user.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { AdminComponent } from './admin/admin.component';
import { PmComponent } from './pm/pm.component';
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

import { httpInterceptorProviders } from './auth/auth-interceptor';

@NgModule({
  declarations: [
    AppComponent,
    CreateOrderComponent,
    CreateCustomerComponent,
    OrderListComponent,
    OrderDetailsComponent,
    LoginComponent,
    HomeComponent,
    CustomerListComponent,
    CustomerDetailsComponent,
    SearchCustomersComponent,
    ProductListComponent,
    ProductDetailsComponent,
    CreateProductComponent,
    CreateCustomerComponent,
    UserComponent,
    RegisterComponent,
    AdminComponent,
    PmComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [httpInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
