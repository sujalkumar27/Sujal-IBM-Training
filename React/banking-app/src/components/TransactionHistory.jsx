import React, { useContext } from "react";
import { BankContext } from "../context/BankContext";

function TransactionHistory() {

  const { state } = useContext(BankContext);

  return (

    <div className="history">

      <h2>Transaction History</h2>

      {
        state.transactions.length === 0 ? (

          <p>No Transactions Yet</p>

        ) : (

          <ul>

            {

              [...state.transactions]
                .reverse()
                .map((item, index) => (

                  <li
                    key={index}
                    className={
                      item.type === "Deposit"
                        ? "deposit-history"
                        : "withdraw-history"
                    }
                  >

                    <h3>

                      {
                        item.type === "Deposit"
                          ? "🟢 Deposit"
                          : "🔴 Withdraw"
                      }

                    </h3>

                    <p>

                      Amount : ₹{item.amount}

                    </p>

                    <p>

                      Remaining Balance : ₹{item.balance}

                    </p>

                    <small>

                      📅 {item.date}

                    </small>

                    <br />

                    <small>

                      ⏰ {item.time}

                    </small>

                  </li>

                ))

            }

          </ul>

        )

      }

    </div>

  );

}

export default TransactionHistory;