import { Component, OnInit } from '@angular/core';

import { Customer } from '../../_models/customer';
import { CustomerService } from '../../_services/customer.service';
import { TokenStorageService } from '../../auth/token-storage.service';


@Component({
  selector: 'create-customer',
  templateUrl: './create-customer.component.html',
  styleUrls: ['./create-customer.component.css']
})
export class CreateCustomerComponent implements OnInit {

  customer: Customer = new Customer();
  submitted = false;

  constructor(private customerService: CustomerService, private tokenStorageService: TokenStorageService) { }

  ngOnInit() {
  }

  newUser(): void {
    this.submitted = false;
    this.customer = new Customer();
  }

  save() {
    this.customerService.createCustomer(this.customer, this.tokenStorageService.getUsername())
      .subscribe(data => console.log(data), error => console.log(error));
    this.customer = new Customer();
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }
}
