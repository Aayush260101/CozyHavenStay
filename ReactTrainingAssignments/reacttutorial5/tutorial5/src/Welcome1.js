import React, { useEffect, useState } from 'react'


const Welcome1 = () => {
    let [pass,setPass]=useState("");
    useEffect(()=>{
        let pass1 = localStorage.getItem("mom");
        setPass(pass1);
    },[])
  return (
    <div>Welcome Hello How Do u do person with id = mom and password = {pass}</div>
  )
}

export default Welcome1