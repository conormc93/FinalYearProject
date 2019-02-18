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

  createCustomer(customer: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}` + `/create`, customer);
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

  getCustomersByCname(cname: string): Observable<any> {
    return this.http.get(`${this.baseUrl}/cname/${cname}`);
  }

  deleteAll(): Observable<any> {
    return this.http.delete(`${this.baseUrl}` + `/delete`, { responseType: 'text' });
  }
}
