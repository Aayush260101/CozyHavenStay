import React, { useState } from 'react'
import { useDispatch } from 'react-redux';
import { issuebook, returnbook } from './BookSlice1';

const App1 = () => {
    let [name,setName] = useState("");
    let [qty,setQty] = useState();
    let dispatch = useDispatch();
  return (
    <div>App1 Component
        <input type="text" placeholder="Enter Book Name" onChange={(e)=>setName(e.target.value)} />
        <input type="text" placeholder="Enter Book Quantity" onChange={(e)=>parseInt(setQty(e.target.value))}/>
        <button onClick={()=>dispatch(issuebook({bookName : name, quantity : qty}))}>Issue</button>
        <button onClick={()=>dispatch(returnbook({bookName : name, quantity : qty}))}>Return</button>
    </div>
  )
}

export default App1