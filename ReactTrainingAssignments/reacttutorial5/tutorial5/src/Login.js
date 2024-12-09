import React, { useState } from 'react'
import "./App.css"
import { useNavigate } from 'react-router-dom';

const Login = () => {
  let nav=useNavigate();
  let [id,setId] = useState("");
  let [pass,setPass] = useState("");

  const verify=()=>{
    if(id==="mom" && pass==="dad")
    {
      localStorage.setItem(id,pass);
      sessionStorage.setItem("flag",true);
      nav("/welcome1");
    }
    else
    nav("/notwelcome",{state:{id}})
  }
  return (
    <div>
        <input type="text" placeholder="Enter your id" onChange={(e)=>setId(e.target.value)}/><br/>
        <input type="password" placeholder="Enter your password" onChange={(e)=>setPass(e.target.value)}/>
        <button onClick={verify}>SignIn</button>
    </div>
  )
}

export default Login