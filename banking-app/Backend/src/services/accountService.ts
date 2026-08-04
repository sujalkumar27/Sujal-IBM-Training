import { Account } from '../models/account';

// In-memory store (replace with a DB later)
const accounts: Account[] = [
  { id: 1, username: 'james', age: 32 },
];

export class AccountService {
  getAll(): Account[] {
    return accounts;
  }

  getById(id: number): Account | undefined {
    return accounts.find((a) => a.id === id);
  }

  create(data: Omit<Account, 'id'>): Account {
    const newAccount: Account = {
      id: accounts.length ? Math.max(...accounts.map((a) => a.id)) + 1 : 1,
      ...data,
    };
    accounts.push(newAccount);
    return newAccount;
  }

  update(id: number, data: Partial<Omit<Account, 'id'>>): Account | null {
    const index = accounts.findIndex((a) => a.id === id);
    if (index === -1) return null;

    accounts[index] = { ...accounts[index], ...data };
    return accounts[index];
  }

  delete(id: number): boolean {
    const index = accounts.findIndex((a) => a.id === id);
    if (index === -1) return false;

    accounts.splice(index, 1);
    return true;
  }
}

export const accountService = new AccountService();