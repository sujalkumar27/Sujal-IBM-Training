import { Routes } from '@angular/router';

import { DashboardComponent } from './dashboard/dashboard';
import { TransactionsComponent } from './transactions/transactions';
import { TransferComponent } from './transfer/transfer';
import { LoginComponent } from './login/login';
import { AuthGuard } from './auth.guard';

export const routes: Routes = [

  {
    path:'login',
    component:LoginComponent
  },

  {
    path:'dashboard',
    component:DashboardComponent,
    canActivate: [AuthGuard]
  },

  {
    path:'transactions',
    component:TransactionsComponent,
    canActivate: [AuthGuard]
  },

  {
    path:'transfer',
    component:TransferComponent,
    canActivate: [AuthGuard]
  },

  {
    path:'',
    redirectTo:'login',
    pathMatch:'full'
  }

];