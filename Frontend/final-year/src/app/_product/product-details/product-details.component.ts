import { Component, OnInit, Input } from '@angular/core';
import { ProductService } from '../../_services/product.service';
import { Product } from '../../_models/product';

import { ProductListComponent } from '../product-list/product-list.component';

@Component({
  selector: 'product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css']
})
export class ProductDetailsComponent implements OnInit {

  @Input() product: Product;

  constructor(private productService: ProductService, private listComponent: ProductListComponent) { }

  ngOnInit() {
  }

  updateActive(isActive: boolean) {
    this.productService.updateProduct(this.product.pid,
      {
        pname: this.product.pname,
        stock: this.product.stock,
        cost_price: this.product.cost_price,
        sale_price: this.product.sale_price
      })
      .subscribe(
        data => {
          console.log(data);
          this.product = data as Product;
        },
        error => console.log(error));
  }

  deleteProduct() {
    this.productService.deleteProduct(this.product.pid)
      .subscribe(
        data => {
          console.log(data);
          this.listComponent.reloadData();
        },
        error => console.log(error));
  }
}
