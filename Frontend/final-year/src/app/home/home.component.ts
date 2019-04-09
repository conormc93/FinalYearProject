import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { TokenStorageService } from '../auth/token-storage.service';
import { Order } from '../_models/order';
import { OrderService } from '../_services/order.service';
import { CustomerService } from '../_services/customer.service';
import { Customer } from '../_models/customer';

import { NgZone } from "@angular/core";
import * as am4core from "@amcharts/amcharts4/core";
import * as am4charts from "@amcharts/amcharts4/charts";
import am4themes_animated from "@amcharts/amcharts4/themes/animated";

am4core.useTheme(am4themes_animated);

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})

export class HomeComponent implements OnInit {
  info: any;
  orders: Observable<Order[]>;
  customers: Observable<Customer[]>;
  private chart: am4charts.PieChart;

  constructor(private token: TokenStorageService,private zone: NgZone, private customerService: CustomerService, private orderService: OrderService) { }

  ngOnInit() {
    this.info = {
      token: this.token.getToken(),
      username: this.token.getUsername(),
      authorities: this.token.getAuthorities()
    };

    this.reloadData();
  }

  ngAfterViewInit() {
    this.zone.runOutsideAngular(() => {
      let chart = am4core.create("chartdiv", am4charts.PieChart);
      chart.paddingRight = 20;
      let data = [];
      
      chart.data = [{
        "customer": "a",
        "amount": 4
      }];
    
      // Add and configure Series
      let pieSeries = chart.series.push(new am4charts.PieSeries());
      pieSeries.dataFields.value = "amount";
      pieSeries.dataFields.category = "customer";
      this.chart = chart;
    });
  }

  ngOnDestroy() {
    this.zone.runOutsideAngular(() => {
      if (this.chart) {
        this.chart.dispose();
      }
    });
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
