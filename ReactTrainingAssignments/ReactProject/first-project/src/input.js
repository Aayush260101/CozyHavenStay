import React, { useState } from 'react'

const Input=()=> {

    
        let [A,setA]=useState();
        let [B,setB]=useState();
        let [C,setC]=useState();

        const handleA=(event)=>{
            setA(parseInt(event.target.value))
        }

        const handleB=(event)=>{
            setB(parseInt(event.target.value))
        }

        const cal=()=>{
            setC(A+B);
        }
    



  return (
    <div>
        <input type="text" placeholder="enter a number" onChange={handleA}/>
        <input type="text" placeholder="enter a number" onChange={handleB}/>
        <h2>Result : {C}</h2>
        <button onClick={cal}>Sum</button>
    </div>
  )
}

export default Input;