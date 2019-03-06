import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { UserService } from '../user.service';

@Component({
  selector: 'search-users',
  templateUrl: './search-users.component.html',
  styleUrls: ['./search-users.component.css']
})
export class SearchUsersComponent implements OnInit {

  name: string;
  users: User[];

  constructor(private dataService: UserService) { }

  ngOnInit() {
    this.name = null;
  }

  private searchUsers() {
    this.dataService.getUsersByName(this.name)
      .subscribe(users => this.users = users);
  }

  onSubmit() {
    this.searchUsers();
  }
}
