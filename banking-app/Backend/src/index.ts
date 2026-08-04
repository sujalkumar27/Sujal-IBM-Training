import express, { Request, Response } from 'express';
import cors from 'cors';
import accountRoutes from './routes/accountRoutes';

const app = express();
app.use(cors());
app.use(express.json());

app.get('/', (_req: Request, res: Response<{ message: string }>): void => {
  res.send({ message: 'Hello From backend!' });
});

app.use('/accounts', accountRoutes);

const PORT = 3000;
app.listen(PORT, () => console.log(`Server running on http://localhost:${PORT}`));