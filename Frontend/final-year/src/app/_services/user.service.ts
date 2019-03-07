import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { User } from '../_models/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private baseUrl = 'http://localhost:8080/api/users';

  constructor(private http: HttpClient) { }

  getUser(uid: number): Observable<Object> {
    return this.http.get(`${this.baseUrl}/${uid}`);
  }

  createUser(user: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}` + `/create`, user);
  }

  updateUser(uid: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${uid}`, value);
  }

  deleteUser(cid: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${cid}`, { responseType: 'text' });
  }

  getUsersList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

  getUsersByName(name: string): Observable<any> {
    return this.http.get(`${this.baseUrl}/name/${name}`);
  }

  deleteAll(): Observable<any> {
    return this.http.delete(`${this.baseUrl}` + `/delete`, { responseType: 'text' });
  }

  register(user: User) {
    return this.http.post(`/users/register`, user);
  }
}
