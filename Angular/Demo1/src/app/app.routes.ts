import { Routes } from '@angular/router';
import { DashboardComponent } from './dashboard.component';
import { TransactionsComponent } from './transactions.component';
import { TransferComponent } from './transfer.component';

export const routes: Routes = [

  {
    path:'dashboard',
    component:DashboardComponent
  },

  {
    path:'transactions',
    component:TransactionsComponent
  },

  {
    path:'transfer',
    component:TransferComponent
  },

  {
    path:'',
    redirectTo:'/dashboard',
    pathMatch:'full'
  }

];