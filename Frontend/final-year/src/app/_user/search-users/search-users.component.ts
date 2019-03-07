import { Component, OnInit } from '@angular/core';
import { User } from '../../_models/user';
import { UserService } from '../../_services/user.service';

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
