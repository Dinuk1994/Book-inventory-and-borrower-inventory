import { CommonModule } from '@angular/common';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-add-borrower',
  standalone: true,
  imports: [HttpClientModule,FormsModule,CommonModule],
  templateUrl: './add-borrower.component.html',
  styleUrl: './add-borrower.component.css'
})
export class AddBorrowerComponent implements OnInit {
    private http :any;

    public name : String = '';
    public nic : string = '';
    public email : string = '';
    public address : string = '';
    public date : string = '';



    constructor(private httpClient : HttpClient){
      this.http = httpClient;
    }

    ngOnInit(): void {
      
    }

    

    saveBorrower(){
       const borrower = {
        name : this.name,
        nic :  this.nic,
        email : this.email,
        address : this.address,
        date : this.date
      };


      this.http.post('http://localhost:8080/borrower/add',borrower).subscribe((data:any)=>{
        console.log(borrower);
        Swal.fire({
          title: "Saved Successfully!",
          text: "You clicked the button!",
          icon: "success"
        });
        // this.clearForm();
      });
    }

    clearForm(){
      this.name = '';
      this.nic = '';
      this.email = '';
      this.address = '';
      this.date = ''
    }
    
   


}
