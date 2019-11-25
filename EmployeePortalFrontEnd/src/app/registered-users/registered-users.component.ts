import { Component, OnInit } from '@angular/core';
import { UserService } from '../_services/user.service';
import { User } from '../_models/user';
import { first } from 'rxjs/internal/operators/first';

@Component({templateUrl: './registered-users.component.html'})
export class RegisteredUsersComponent implements OnInit {

  users: User[] = [];

  constructor(private userService: UserService) {
  }
  ngOnInit() {
      this.loadAllUsers();
  }

  private loadAllUsers() {
      this.userService.getAllEmployees().pipe(first()).subscribe(users => { 
          this.users = users; 
      });
  }

}
