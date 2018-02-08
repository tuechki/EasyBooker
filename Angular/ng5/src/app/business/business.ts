export class Business {
  name: '';
  summary: '';
  email: '';

  constructor(values: Object = {}) {
    Object.assign(this, values);
  }
}
