import React from 'react'
import { useLocation } from 'react-router-dom'
import "./App.css";

const Display = () => {
    let data=useLocation();
    let {name,salary}=data.state;
    salary=parseFloat(salary);
    
    let bonus=0.05*salary;
    let total = salary+bonus;
    

  return (
    <div className="div1">PaySlip
        <h1>Name : {name}</h1>
        <h1>Salary : {salary}</h1>
        <h1>Bonus : {bonus}</h1>
        <h1>TotalSalary : {total}</h1>
    </div>
  )
}

export default Display