import { createStore } from "redux";

// Initial state
const initialState = {
    balance: 1000
};

// Reducer: defines how state changes based on action
function bankReducer(state = initialState, action) {

    switch (action.type) {

        case "DEPOSIT":
            return {
                ...state,
                balance: state.balance + action.amount
            };

        case "WITHDRAW":
            return {
                ...state,
                balance: state.balance - action.amount
            };

        default:
            return state;
    }
}

// Create Redux store with reducer
const store = createStore(bankReducer);

export default store;