import { CommonModule } from '@angular/common';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-users',
  standalone: true,
  imports: [HttpClientModule,FormsModule,CommonModule],
  templateUrl: './users.component.html',
  styleUrl: './users.component.css'
})
export class UsersComponent implements OnInit {
  private http :any
  public userList : any =[]

  constructor(private httpClient : HttpClient){
      this.http = httpClient
  }

  ngOnInit(): void {
    this.loadUsers();
  }

  loadUsers(){
    this.http.get('http://localhost:8080/user/get').subscribe((data:any)=>{
      this.userList = data;
      console.log(data);
    })
  }

}
