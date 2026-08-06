import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { BankingService } from './banking.service';

describe('BankingService', () => {
  let service: BankingService;
  let httpMock: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [BankingService]
    });

    service = TestBed.inject(BankingService);
    httpMock = TestBed.inject(HttpTestingController);
  });

  afterEach(() => {
    httpMock.verify();
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should send a transfer request and return response', () => {
    const requestBody = { fromAccount: 'A1', toAccount: 'B1', amount: 2500 };
    const mockResponse = { success: true, transferred: 2500 };

    service.transferFunds(requestBody).subscribe(response => {
      expect(response).toEqual(mockResponse);
    });

    const req = httpMock.expectOne('https://api.mybank.com/transfer');
    expect(req.request.method).toBe('POST');
    expect(req.request.body).toEqual(requestBody);
    req.flush(mockResponse);
  });

  it('should fetch transactions for an account', () => {
    const accountId = 'A1';
    const transactions = [{ id: 'txn1', amount: 100 }];

    service.getTransactions(accountId).subscribe(data => {
      expect(data).toEqual(transactions);
    });

    const req = httpMock.expectOne(`https://api.mybank.com/accounts/${accountId}/transactions`);
    expect(req.request.method).toBe('GET');
    req.flush(transactions);
  });

  it('should return a user-friendly error when transfer fails', () => {
    const requestBody = { fromAccount: 'A1', toAccount: 'B1', amount: 2500 };

    service.transferFunds(requestBody).subscribe({
      next: () => fail('Expected an error'),
      error: err => {
        expect(err).toBeTruthy();
        expect(err.message).toBe('Transfer request failed. Please try again.');
      }
    });

    const req = httpMock.expectOne('https://api.mybank.com/transfer');
    req.error(new ErrorEvent('Network error'));
  });

  it('should return a user-friendly error when transaction fetch fails', () => {
    const accountId = 'A1';

    service.getTransactions(accountId).subscribe({
      next: () => fail('Expected an error'),
      error: err => {
        expect(err).toBeTruthy();
        expect(err.message).toBe('Could not load transactions.');
      }
    });

    const req = httpMock.expectOne(`https://api.mybank.com/accounts/${accountId}/transactions`);
    req.error(new ErrorEvent('Network error'));
  });
});
