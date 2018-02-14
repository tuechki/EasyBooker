import { Injectable } from '@angular/core';

@Injectable()
export class BusinessInfoService {

  private currentBusiness: any;

  public getCurrentBusiness(){
    return this.currentBusiness;
  }

  public setCurrentBusiness(currentBusiness){
    this.currentBusiness = currentBusiness;
  }

  public clearCurrentBusiness() {
    this.currentBusiness = null;
  }

}
