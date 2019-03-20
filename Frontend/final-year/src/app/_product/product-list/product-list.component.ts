import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';

import { ProductService } from '../../_services/product.service';
import { Product } from '../../_models/product';
import { TokenStorageService } from '../../auth/token-storage.service';

@Component({
  selector: 'product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  products: Observable<Product[]>;

  constructor(private productService: ProductService, private tokenStorageService: TokenStorageService) { }

  ngOnInit() {
    this.reloadData();
  }

  deleteUsers() {
    this.productService.deleteAll()
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log('ERROR: ' + error));
  }

  reloadData() {
    this.products = this.productService.getProductsByUid(this.tokenStorageService.getUsername());
  }
}
