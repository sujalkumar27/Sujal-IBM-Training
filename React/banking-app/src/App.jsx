import React from "react";
import Dashboard from "./components/Dashboard";
import { BankProvider } from "./context/BankContext";

function App() {
  return (
    <BankProvider>
      <Dashboard />
    </BankProvider>
  );
}

export default App;