import "./App.css"
import React from 'react'
const Card=({name,age,pic})=> {

    
  return (
    <div className="div1">
        <h1>Name : {name}</h1>
        <h2>Age : {age}</h2>
        <img alt="" src={pic}/>

    </div>
  )
}

export default Card