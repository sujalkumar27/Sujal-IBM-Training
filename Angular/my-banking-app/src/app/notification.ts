import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class NotificationService {

  notifyUser(message: string) {
    alert(message);
    console.log('Notification:', message);
  }

}