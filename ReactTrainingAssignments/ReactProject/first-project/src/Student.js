import React, { useState } from 'react'
import StudentPass from './StudentPass';
import StudentFail from './StudentFail';
import "./App.css"

const Student=()=> {
    let [name,setName]=useState("");
    let [marks1,setMarks1]=useState(0);
    let [marks2,setMarks2]=useState(0);
    let [marks3,setMarks3]=useState(0);
    let [marks4,setMarks4]=useState(0);
    let [marks5,setMarks5]=useState(0);
    let [avg,setAvg]=useState(0);

    const studentname=(event)=>{
        setName(event.target.value)
    }

    const studentmark1=(event)=>{
        setMarks1(parseInt(event.target.value));
    }

    const studentmark2=(event)=>{
        setMarks2(parseInt(event.target.value));
    }

    const studentmark3=(event)=>{
        setMarks3(parseInt(event.target.value));
    }

    const studentmark4=(event)=>{
        setMarks4(parseInt(event.target.value));
    }

    const studentmark5=(event)=>{
        setMarks5(parseInt(event.target.value));
    }

    const calculateaverage=()=>{
        setAvg((marks1+marks2+marks3+marks4+marks5)/5)
    }






  return (
    <div className="div1">
        <input type="text" placeholder="Enter Student name" onChange={studentname}/>
        <input type="number" placeholder="Enter Math marks" onChange={studentmark1}/>
        <input type="number" placeholder="Enter Science marks" onChange={studentmark2}/>
        <input type="number" placeholder="Enter English marks" onChange={studentmark3}/>
        <input type="number" placeholder="Enter Hindi marks" onChange={studentmark4}/>
        <input type="number" placeholder="Enter Sanskrit marks" onChange={studentmark5}/>
        <button onClick={calculateaverage}>Display Result</button>
        {
            avg===0 ? null : avg>=40 ? <StudentPass name={name} avg={avg}/> : <StudentFail name={name} avg={avg}/>
        }






    </div>
  )
}

export default Student