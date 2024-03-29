import { CommonModule } from '@angular/common';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import Swal from 'sweetalert2';

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
    public selectedBorrower :  any

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

    setSelectedBorrower(borrower : any){
      this.selectedBorrower = borrower
      console.log(borrower.borrowerId)
    }

    deleteBorrower(){
      this.http.delete(`http://localhost:8080/borrower/${this.selectedBorrower.borrowerId}`,{responseType : 'text'}).subscribe((response : string)=>{
        console.log(response)
        this.loadBorrowers();
      })
      Swal.fire({
        title: "Deleted!",
        text: `${this.selectedBorrower.name} is Deleted`,
        icon: "success"
      });
      this.selectedBorrower=null;
    }

    saveBorrower(){
      this.http.post('http://localhost:8080/borrower/add',this.selectedBorrower).subscribe((data:any)=>{
        console.log("saved!");
        this.loadBorrowers();
        Swal.fire({
          title: "Updated Successfully!",
          text: "You clicked the button!",
          icon: "success"
        });
        this.selectedBorrower=null;
      });
    }

}
