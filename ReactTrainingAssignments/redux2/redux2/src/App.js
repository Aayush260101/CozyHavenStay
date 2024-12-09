import React, { useState } from "react";

import Library from "./Library";
import App1 from "./App1";

const App = () => {
  const [role, setRole] = useState(""); 

  return (
    <div>
      <h1>Library Management System</h1>
      <div>
        <button onClick={() => setRole("admin")}>Switch to Admin</button>
        <button onClick={() => setRole("user")}>Switch to User</button>
      </div>
      {role === "admin" && <Library />}
      {role === "user" && <App1 />}
    </div>
  );
};

export default App;




// import { useState } from 'react';
// import './App.css';
// import { useDispatch, useSelector } from 'react-redux';
// import { buyDSABkN, returnDSABkN ,buyjavaBkN, returnjavaBkN} from './BookSlice';
 
// function App() {
//   let [n,setN] = useState()
//   let {dsa,java} = useSelector((state)=>state)
 
//   let dispatch = useDispatch()
 
//   return (
//     <div className="cont">
//       <h1>DSA {dsa}</h1>
//       <h1>Java {java}</h1>
//       <input type='text' placeholder='enter a number' onChange={(e)=>setN(e.target.value)}/>
//       <button onClick={()=>dispatch(buyDSABkN(n))}>Buy DSA n Books</button>
//       <button onClick={()=>dispatch(returnDSABkN(n))}>Return DSA n Books</button>
//       <button onClick={()=>dispatch(buyjavaBkN(n))}>Buy java n Books</button>
//       <button onClick={()=>dispatch(returnjavaBkN(n))}>Return java n Books</button>
//     </div>
//   );
// }
 
// export default App;