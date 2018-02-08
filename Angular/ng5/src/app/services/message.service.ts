import { Injectable } from '@angular/core';

@Injectable()
export class CreateBusinessService {

  private message: string = '';
  private businessId: number = null;

  setBusinessId(value) {
    this.businessId = value;
  }

  getBusinessId() {
    return this.businessId;
  }


  setMessage(value) {
    this.message = value;
  }

  getMessage() {
    return this.message;
  }


  clearMessage() {
    this.message = null;
  }

}
