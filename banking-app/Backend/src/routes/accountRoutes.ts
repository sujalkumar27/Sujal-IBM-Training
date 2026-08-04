import { Router } from 'express';
import { accountController } from '../controllers/accountController';

const router = Router();

router.get('/', accountController.getAllAccounts);
router.get('/:id', accountController.getAccountById);
router.post('/', accountController.createAccount);

export default router;

