import React, { useState } from 'react'
import "./App.css";

const StudentFail=({name,avg})=> {

  return (
    <div className="div1">StudentPass
        <h1>Welcome {name}</h1>
        <h1>Total Marks {avg*5}</h1>
        <h1>Better Luck Next Time</h1>

    </div>
  )
}

export default StudentFail