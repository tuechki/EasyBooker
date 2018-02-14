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


  clearBusinessId(){
    this.businessId = null;
  }

}
