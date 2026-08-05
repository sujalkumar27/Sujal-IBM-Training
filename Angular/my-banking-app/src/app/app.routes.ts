import { Routes } from '@angular/router';

import { DashboardComponent } from './dashboard/dashboard';
import { TransactionsComponent } from './transactions/transactions';
import { TransferComponent } from './transfer/transfer';
import { LoginComponent } from './login/login';

export const routes: Routes = [

  {
    path:'login',
    component:LoginComponent
  },

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
    redirectTo:'login',
    pathMatch:'full'
  }

];