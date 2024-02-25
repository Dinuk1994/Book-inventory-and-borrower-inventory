import { CommonModule } from '@angular/common';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-view-all-borrowers',
  standalone: true,
  imports: [HttpClientModule,FormsModule,CommonModule],
  templateUrl: './view-all-borrowers.component.html',
  styleUrl: './view-all-borrowers.component.css'
})
export class ViewAllBorrowersComponent implements OnInit {
    private http : any;
    public borrowerList : any =[];

    constructor(private httpClient : HttpClient){
      this.http = httpClient;
    }

    ngOnInit(): void {
      this.loadBorrowers();
    }

    loadBorrowers(){
      this.http.get('http://localhost:8080/borrower/get').subscribe((data : any)=>{
        this.borrowerList=data;
        console.log(data);
      })
    }

}
