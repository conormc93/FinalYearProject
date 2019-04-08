import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { TokenStorageService } from '../auth/token-storage.service';
import { Order } from '../_models/order';
import { OrderService } from '../_services/order.service';
import { CustomerService } from '../_services/customer.service';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  info: any;
  orders: Observable<Order[]>;

  constructor(private token: TokenStorageService, private customerService: CustomerService, private orderService: OrderService) { }

  ngOnInit() {
    this.info = {
      token: this.token.getToken(),
      username: this.token.getUsername(),
      authorities: this.token.getAuthorities()
    };
    this.reloadData();
  }

  logout() {
    this.token.signOut();
    window.location.reload();
  }
   reloadData() {
    this.orders = this.orderService.getRecentOrders(this.token.getUsername());
    this.customers = this.customerService.getTopCustomers(this.token.getUsername());
  }
}
