import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private baseUrl = 'http://localhost:8080/api/products';

  constructor(private http: HttpClient) { }

  getProduct(pid: number): Observable<Object> {
    return this.http.get(`${this.baseUrl}/${pid}`);
  }

  createProduct(product: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}` + `/create`, product);
  }

  updateProduct(pid: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${pid}`, value);
  }

  deleteProduct(pid: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${pid}`, { responseType: 'text' });
  }

  getProductsList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

  getProductsByName(name: string): Observable<any> {
    return this.http.get(`${this.baseUrl}/name/${name}`);
  }

  deleteAll(): Observable<any> {
    return this.http.delete(`${this.baseUrl}` + `/delete`, { responseType: 'text' });
  }
}
