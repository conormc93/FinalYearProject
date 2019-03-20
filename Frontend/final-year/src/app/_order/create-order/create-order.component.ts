import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';

import { Order } from '../../_models/order';
import { OrderService } from '../../_services/order.service';

import { Customer } from '../../_models/customer';
import { CustomerService } from '../../_services/customer.service';
import { TokenStorageService } from '../../auth/token-storage.service';

@Component({
  selector: 'create-order',
  templateUrl: './create-order.component.html',
  styleUrls: ['./create-order.component.css']
})
export class CreateOrderComponent implements OnInit {

  order: Order = new Order();
  submitted = false;
  customers: Observable<Customer[]>;

  constructor(private orderService: OrderService, private customerService: CustomerService,
              private tokenStorageService: TokenStorageService) { }

  ngOnInit() {
    this.reloadData();
  }

  newProduct(): void {
    this.submitted = false;
    this.order = new Order();
  }

  save() {
    this.orderService.createOrder(this.order)
      .subscribe(data => console.log(data), error => console.log(error));
    this.order = new Order();
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }

  reloadData() {
    this.customers = this.customerService.getCustomersByUid(this.tokenStorageService.getUsername());
  }
}
