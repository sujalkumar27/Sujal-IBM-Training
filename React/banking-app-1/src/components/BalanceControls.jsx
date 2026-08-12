import React from "react";
import { useDispatch } from "react-redux";

// Component for deposit and withdraw actions
function BalanceControls() {

    const dispatch = useDispatch();

    const deposit = () => {
        dispatch({
            type: "DEPOSIT",
            amount: 500
        });
    };

    const withdraw = () => {
        dispatch({
            type: "WITHDRAW",
            amount: 200
        });
    };

    return (
        <div>

            <button onClick={deposit}>
                Deposit ₹500
            </button>

            <button onClick={withdraw}>
                Withdraw ₹200
            </button>

        </div>
    );
}

export default BalanceControls;