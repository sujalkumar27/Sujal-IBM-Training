import React, { useContext, useMemo } from "react";
import { BankContext } from "../context/BankContext";

import Account from "./Account";
import TransactionForm from "./TransactionForm";
import TransactionHistory from "./TransactionHistory";

import "./Dashboard.css";

function Dashboard() {

  const { state } = useContext(BankContext);

  const totalDeposit = useMemo(() => {

    return state.transactions
      .filter((item) => item.type === "Deposit")
      .reduce((total, item) => total + item.amount, 0);

  }, [state.transactions]);



  const totalWithdraw = useMemo(() => {

    return state.transactions
      .filter((item) => item.type === "Withdraw")
      .reduce((total, item) => total + item.amount, 0);

  }, [state.transactions]);



  return (

    <div className="dashboard">

      <h1>🏦 Mirchi Bank</h1>

      <h3>Welcome Back</h3>

      <Account />

      <TransactionForm />

      <div className="summary">

        <div className="summary-card">

          <h3>Total Deposit</h3>

          <h2>₹ {totalDeposit}</h2>

        </div>

        <div className="summary-card">

          <h3>Total Withdraw</h3>

          <h2>₹ {totalWithdraw}</h2>

        </div>

      </div>


      {

        state.balance <= 200 &&
        state.balance > 0 && (

          <p className="warning">

            ⚠️ Low Balance

          </p>

        )

      }


      {

        state.balance === 0 && (

          <p className="danger">

            🚫 Zero Balance

          </p>

        )

      }


      <h3

        className={
          state.status.includes("❌")
            ? "error"
            : "success"
        }

      >

        {state.status}

      </h3>


      <TransactionHistory />

    </div>

  );

}

export default Dashboard;