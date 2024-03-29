import { CommonModule } from '@angular/common';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component, OnInit} from '@angular/core';
import { FormsModule } from '@angular/forms';
import { NgModel } from '@angular/forms';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [HttpClientModule,FormsModule,CommonModule],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent implements OnInit{
  private http;
  public countryList : any
  public selectedCountry : any

  constructor(private httpClient :HttpClient){
    this.http = httpClient
  }

  ngOnInit(): void {
    this.loadCountries();
  }

  loadCountries(){
      this.http.get('https://restcountries.com/v3.1/all').subscribe((data:any)=>{
        this.countryList=data;
        console.log(data);
        
      });
  }

  setSelectedCountry(country : any){
    this.selectedCountry=country;
    console.log(this.selectedCountry);
  }

}
