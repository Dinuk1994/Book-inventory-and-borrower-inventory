import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { NavComponent } from './common/nav/nav.component';
import { ViewAllBooksComponent } from './page/view-all-books/view-all-books.component';
import { LoginComponent } from './page/login/login.component';
import { RegisterComponent } from './page/register/register.component';
import { ViewAllBorrowersComponent } from './page/view-all-borrowers/view-all-borrowers.component';
import { AddBorrowerComponent } from './page/add-borrower/add-borrower.component';
import { UsersComponent } from './page/users/users.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet,NavComponent,ViewAllBooksComponent,LoginComponent,RegisterComponent,ViewAllBorrowersComponent,AddBorrowerComponent,UsersComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'library-manage-frontend';
}
