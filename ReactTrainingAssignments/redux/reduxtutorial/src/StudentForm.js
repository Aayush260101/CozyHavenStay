import React, { useContext, useState } from 'react'
import  { studentContext1 } from './StudentContext';

const StudentForm = () => {
    const {setStudent}=useContext(studentContext1);
    const [name,setName] = useState("");
    const [fee,setFee] = useState(0);

    
    const add = ()=>{
        setStudent({name,fee});
    }
  return (
    <div>StudentForm
        <input type="text" placeholder="Enter Name" onChange={(e)=>setName(e.target.value)}/>
        <input type="text" placeholder="Enter Fee" onChange={(e)=>setFee(e.target.value)}/>
        <button onClick={add}>OK</button>
    </div>
  )
}

export default StudentForm