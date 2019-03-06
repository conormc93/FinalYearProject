import { Component, OnInit } from '@angular/core';
import { Customer } from '../customer';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'search-customers',
  templateUrl: './search-customers.component.html',
  styleUrls: ['./search-customers.component.css']
})
export class SearchCustomersComponent implements OnInit {

  name: string;
  customers: Customer[];

  constructor(private dataService: CustomerService) { }

  ngOnInit() {
    this.name = null;
  }

  private searchCustomers() {
    this.dataService.getCustomersByName(this.name)
      .subscribe(customers => this.customers = customers);
  }

  onSubmit() {
    this.searchCustomers();
  }
}
