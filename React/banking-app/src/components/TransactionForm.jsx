import React,
{
  useState,
  useContext,
  useRef
} from "react";

import { BankContext } from "../context/BankContext";

import TransactionButton from "./TransactionButton";

function TransactionForm() {

  const [amount, setAmount] = useState("");

  const inputRef = useRef();

  const { state, handleTransaction } =
    useContext(BankContext);



  const performTransaction = (type) => {

    const amt = Number(amount);

    if (amt <= 0) {

      alert("Enter valid amount");

      return;

    }


    if (
      type === "Withdraw" &&
      amt > state.balance
    ) {

      alert("Insufficient Balance");

      return;

    }


    handleTransaction(type, amt);

    setAmount("");

    inputRef.current.focus();

  };



  return (

    <div className="transaction-form">

      <input

        ref={inputRef}

        type="number"

        min="1"

        placeholder="Enter Amount"

        value={amount}

        onChange={(e) =>
          setAmount(e.target.value)
        }

      />



      {

        amount !== "" &&
        Number(amount) <= 0 && (

          <p className="error">

            Invalid Amount

          </p>

        )

      }



      <div className="btn-group">

        <TransactionButton

          text="Deposit"

          onClick={() =>
            performTransaction("Deposit")
          }

        />



        <TransactionButton

          text="Withdraw"

          onClick={() =>
            performTransaction("Withdraw")
          }

        />

      </div>

    </div>

  );

}

export default TransactionForm;