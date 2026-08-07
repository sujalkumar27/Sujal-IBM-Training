import React,
{
  createContext,
  useReducer,
  useEffect,
  useCallback
} from "react";

import {
  bankReducer,
  initialState
} from "../reducer/bankReducer";

export const BankContext = createContext();

export function BankProvider({ children }) {

  const [state, dispatch] =
    useReducer(bankReducer, initialState);

  useEffect(() => {

    document.title =
      `Balance : ₹${state.balance}`;

  }, [state.balance]);


  const handleTransaction =
    useCallback((type, amount) => {

      dispatch({

        type:
          type === "Deposit"
            ? "DEPOSIT"
            : "WITHDRAW",

        payload: amount

      });

    }, []);


  return (

    <BankContext.Provider
      value={{
        state,
        handleTransaction
      }}
    >

      {children}

    </BankContext.Provider>

  );

}