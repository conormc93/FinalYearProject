import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  private baseUrl = 'http://localhost:8080/api/orders';

  constructor(private http: HttpClient) { }

  getOrder(oid: number): Observable<Object> {
    return this.http.get(`${this.baseUrl}/${oid}`);
  }

  createOrder(order: Object, username: string): Observable<Object> {
    return this.http.post(`${this.baseUrl}/${username}` + `/create`, order);
  }

  updateOrder(oid: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${oid}`, value);
  }

  deleteOrder(oid: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${oid}`, { responseType: 'text' });
  }

  getOrdersList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

  getOrderssByID(oid: string): Observable<any> {
    return this.http.get(`${this.baseUrl}/oid/${oid}`);
  }
  
  getOrdersByUid(username: string): Observable<any> {
    return this.http.get(`${this.baseUrl}/${username}`);
  }

  getRecentOrders(username: string): Observable<any> {
    return this.http.get(`${this.baseUrl}/recent/${username}`);
  }

  deleteAll(): Observable<any> {
    return this.http.delete(`${this.baseUrl}` + `/delete`, { responseType: 'text' });
  }

}
