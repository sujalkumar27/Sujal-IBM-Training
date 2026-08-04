import { Request, Response } from 'express';
import { Account } from '../models/account';
import { accountService } from '../services/accountService';

class AccountController {
  getAllAccounts = (_req: Request, res: Response): void => {
    res.json(accountService.getAll());
  };

  getAccountById = (req: Request, res: Response): void => {
    const account = accountService.getById(Number(req.params.id));

    if (!account) {
      res.status(404).json({ message: 'Account not found' });
      return;
    }

    res.json(account);
  };

  createAccount = (req: Request, res: Response): void => {
    const { username, age } = req.body as Omit<Account, 'id'>;
    const account = accountService.create({ username, age });
    res.status(201).json(account);
  };
}

export const accountController = new AccountController();
