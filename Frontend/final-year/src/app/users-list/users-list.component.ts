import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';

import { UserService } from '../user.service';
import { User } from '../user';

@Component({
  selector: 'users-list',
  templateUrl: './users-list.component.html',
  styleUrls: ['./users-list.component.css']
})
export class UsersListComponent implements OnInit {

  users: Observable<User[]>;

  constructor(private userService: UserService) { }

  ngOnInit() {
    this.reloadData();
  }

  deleteUsers() {
    this.userService.deleteAll()
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log('ERROR: ' + error));
  }

  reloadData() {
    this.users = this.userService.getUsersList();
  }
}
