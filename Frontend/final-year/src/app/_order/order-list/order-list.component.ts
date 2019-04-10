import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';

import { OrderService } from '../../_services/order.service';
import { Order } from '../../_models/order';
import { TokenStorageService } from '../../auth/token-storage.service';


@Component({
  selector: 'app-order-list',
  templateUrl: './order-list.component.html',
  styleUrls: ['./order-list.component.css']
})

export class OrderListComponent implements OnInit {

  orders: Observable<Order[]>;

  constructor(private orderService: OrderService, private tokenStorageService: TokenStorageService) { }

  ngOnInit() {
    this.reloadData();
  }

  deleteCustomers() {
    this.orderService.deleteAll()
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log('ERROR: ' + error));
  }

  reloadData() {
    this.orders = this.orderService.getOrdersByUid(this.tokenStorageService.getUsername());
  }
}
