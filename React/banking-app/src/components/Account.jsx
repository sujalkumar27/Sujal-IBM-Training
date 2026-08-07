import React, { useContext } from "react";

import { BankContext } from "../context/BankContext";

function Account() {

  const { state } = useContext(BankContext);

  return (

    <div className="account-card">

      <h2>💰 Current Balance</h2>

      <h1>

        ₹ {state.balance}

      </h1>

    </div>

  );

}

export default Account;