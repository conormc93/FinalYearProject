import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';

import { Order } from '../order';
import { OrderService } from '../order.service';

@Component({
  selector: 'create-order',
  templateUrl: './create-order.component.html',
  styleUrls: ['./create-order.component.css']
})
export class CreateOrderComponent implements OnInit {

  order: Order = new Order();
  submitted = false;


  constructor(private orderService: OrderService) { }

  ngOnInit() {
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
}
