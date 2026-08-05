import { TestBed } from '@angular/core/testing';

import { FundTransfer } from './fund-transfer';

describe('FundTransfer', () => {
  let service: FundTransfer;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FundTransfer);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
