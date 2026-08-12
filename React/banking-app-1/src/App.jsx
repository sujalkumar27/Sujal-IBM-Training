
// import "./index.css";
// import Accounts from "./pages/Accounts";
// import Home from "./pages/Home";
// import About from "./pages/About";
// import { BrowserRouter,Route,Routes } from "react-router-dom";
// function App() {
//   return (
//     <BrowserRouter>
//       <Routes>
//         <Route path="/" element={<Home />} />
//         <Route path="/accounts" element={<Accounts />} />
//         <Route path="/about" element={<About />} />
//       </Routes>
//     </BrowserRouter>
//   );
// }

// export default App;
import React from "react";
import { useSelector } from "react-redux";

import BalanceControls from "./components/BalanceControls";

function App() {

    // Get balance from Redux store
    const balance = useSelector(
        (state) => state.balance
    );

    return (
        <div>

            <h1>Banking Application</h1>

            <h2>
                Current Balance: ₹{balance}
            </h2>

            <BalanceControls />

        </div>
    );
}

export default App;