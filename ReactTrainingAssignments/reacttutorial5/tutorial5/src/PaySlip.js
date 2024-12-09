import { useState } from "react"
import { useNavigate } from "react-router-dom";
import "./App.css"
 
const PaySlip=()=>
{
  let nav=useNavigate();
let [name,setName]=useState();
let [salary,setSalary]=useState();

const goto=()=>{
  nav("/display",{state:{name,salary}})
}

 
 
 
return(<>
 
<div className="div1">
   
   <input type="text" placeholder="enter ur Name" onChange={(e)=>setName(e.target.value)}/><br/>
   
   <input type="text" placeholder="enter ur Salary" onChange={(e)=>setSalary(e.target.value)}/><br/>
 
  <button onClick={goto}> show Payslip </button>
 
  </div>
 
</>)
 
 
}
export default PaySlip