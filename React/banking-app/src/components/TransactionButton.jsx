import React from "react";

function TransactionButton({ text, onClick }) {
  return (
    <button
      className={
        text === "Deposit"
          ? "deposit-btn"
          : "withdraw-btn"
      }
      onClick={onClick}
    >
      {text}
    </button>
  );
}

export default React.memo(TransactionButton);