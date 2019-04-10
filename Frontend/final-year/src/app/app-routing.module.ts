import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { UserComponent } from './user/user.component';
import { PmComponent } from './pm/pm.component';
import { AdminComponent } from './admin/admin.component';
import { CustomerListComponent } from './_customer/customer-list/customer-list.component';
import { ProductListComponent } from './_product/product-list/product-list.component';
import { OrderListComponent } from './_order/order-list/order-list.component';
import { SearchCustomersComponent } from './_customer/search-customers/search-customers.component';
import { CreateProductComponent } from './_product/create-product/create-product.component';
import { CreateCustomerComponent } from './_customer/create-customer/create-customer.component';
import { CreateOrderComponent } from './_order/create-order/create-order.component';

const routes: Routes = [
    {path: 'home', component: HomeComponent},
    {path: 'user', component: UserComponent},
    {path: 'pm', component: PmComponent},
    {path: 'admin', component: AdminComponent},
    {path: 'auth/login', component: LoginComponent},
    {path: 'signup', component: RegisterComponent},
    { path: 'addProduct', component: CreateProductComponent },
    { path: 'addCustomer', component: CreateCustomerComponent },
    { path: 'addOrder', component: CreateOrderComponent },
    { path: 'findbyname', component: SearchCustomersComponent },
    { path: 'customer', component: CustomerListComponent },
    { path: 'product', component: ProductListComponent },
    { path: 'order', component: OrderListComponent },
    {path: '', redirectTo: 'home', pathMatch: 'full' },
    { path: '**', redirectTo: '' }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }
