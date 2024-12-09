import React, { useState } from 'react'
import "./App.css"
const Counter=()=> {

    //let c=0;

    let[count,setCount]=useState(5);

    const add=()=>{
        setCount(count-1);
        if(count===1)
          setCount(5);
    }
  return (<div className="div1">
    <h1>Counter Application</h1>
    <h1>{count}</h1>
    <button onClick={add}>ClickMe</button>
    </div>

  )
}

export default Counter;