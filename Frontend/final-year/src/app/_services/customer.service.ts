import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  private baseUrl = 'http://localhost:8080/api/customers';

  constructor(private http: HttpClient) { }

  getCustomer(cid: number): Observable<Object> {
    return this.http.get(`${this.baseUrl}/${cid}`);
  }

  createCustomer(customer: Object, username: string): Observable<Object> {
    return this.http.post(`${this.baseUrl}/${username}` + `/create`, customer);
  }

  updateCustomer(cid: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${cid}`, value);
  }

  deleteCustomer(cid: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${cid}`, { responseType: 'text' });
  }

  getCustomersList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

  getCustomersByName(name: string): Observable<any> {
    return this.http.get(`${this.baseUrl}/name/${name}`);
  }

  getCustomersByUid(username: string): Observable<any> {
    return this.http.get(`${this.baseUrl}/${username}`);
  }

  getTopCustomers(username: string): Observable<any> {
    return this.http.get(`${this.baseUrl}/top/${username}`);
  }

   getChartData(username: string): Observable<any> {
    return this.http.get(`${this.baseUrl}/data/${username}`);
  }

  deleteAll(): Observable<any> {
    return this.http.delete(`${this.baseUrl}` + `/delete`, { responseType: 'text' });
  }
}
