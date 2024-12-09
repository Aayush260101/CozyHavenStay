import React from 'react'
import { useLocation } from 'react-router-dom'

const Welcome = () => {
    let data=useLocation();
    let {id,pass}=data.state;
    console.log(data);
  return (
    <div>Welcome Hello How Do u do {id}</div>
  )
}

export default Welcome