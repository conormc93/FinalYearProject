import { Component, OnInit, Input } from '@angular/core';
import { OrderService } from '../../_services/order.service';
import { Order } from '../../_models/order';

import { OrderListComponent } from '../order-list/order-list.component';

@Component({
  selector: 'order-details',
  templateUrl: './order-details.component.html',
  styleUrls: ['./order-details.component.css']
})

export class OrderDetailsComponent implements OnInit {

  @Input() order: Order;

  constructor(private orderService: OrderService, private listComponent: OrderListComponent) { }

  ngOnInit() { }


  deleteOrder() {
    this.orderService.deleteOrder(this.order.oid)
      .subscribe(
        data => {
          console.log(data);
          this.listComponent.reloadData();
        },
        error => console.log(error));
  }
}
