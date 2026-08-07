export const initialState = {
  balance: 1000,
  transactions: [],
  status: ""
};

export function bankReducer(state, action) {

  switch (action.type) {

    case "DEPOSIT":

      return {

        ...state,

        balance: state.balance + action.payload,

        status: `✅ ₹${action.payload} Deposited Successfully`,

        transactions: [
          ...state.transactions,
          {
            type: "Deposit",
            amount: action.payload,
            balance: state.balance + action.payload,
            date: new Date().toLocaleDateString(),
            time: new Date().toLocaleTimeString()
          }
        ]
      };



    case "WITHDRAW":

      if (action.payload > state.balance) {

        return {

          ...state,

          status: "❌ Insufficient Balance"

        };

      }

      return {

        ...state,

        balance: state.balance - action.payload,

        status: `✅ ₹${action.payload} Withdrawn Successfully`,

        transactions: [
          ...state.transactions,
          {
            type: "Withdraw",
            amount: action.payload,
            balance: state.balance - action.payload,
            date: new Date().toLocaleDateString(),
            time: new Date().toLocaleTimeString()
          }
        ]
      };


    default:
      return state;

  }

}