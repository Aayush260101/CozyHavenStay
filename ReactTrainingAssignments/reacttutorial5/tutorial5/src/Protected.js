import React, { useEffect } from 'react'
import { useNavigate } from 'react-router-dom';

const Protected = ({Component}) => {
    
    const nav = useNavigate();
    useEffect(()=>{
        let flag=sessionStorage.getItem("flag")
        console.log(flag);
        if(flag!=="true")
        {
            nav("/signin");
        }
    },[nav])
  return (
    <>
    <Component/>
    </>
  )
}

export default Protected