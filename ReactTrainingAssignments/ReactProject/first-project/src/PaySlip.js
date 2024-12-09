import React, { useState } from 'react'
import "./App.css"
const PaySlip=()=> {
    let [salary,setSalary]=useState(0);
    let [leave,setLeave]=useState(0);
    let [totalsal,setTotalsal]=useState(0);
    

    const handlesalary=(event)=>{
        setSalary(parseInt(event.target.value));
    }

    const handleleave=(event)=>{
        setLeave(parseInt(event.target.value));
    }

    
        
    

    
        
    

    const totalsala=()=>{
        let bonus = salary * 0.05; 
        let leaveamt = (salary / 30) * leave;
        setTotalsal(salary+bonus-leaveamt)
    }




  return (
    <div className="div1">

        <h1>Payslip Calculation</h1>
        <input type="text" placeholder="Enter your Salary" onChange={handlesalary} value={salary}/>
        <input type="text" placeholder="Enter no of leaves" onChange={handleleave} value={leave}/>

        <h1>Bonus 5% : {salary * 0.05}</h1>
        <h2>Leave Amount : {(salary / 30) * leave}</h2>
        <h2>Total Salary : {totalsal} </h2>

        <button onClick={totalsala}>Salary</button>
    </div>
  )
}

export default PaySlip