import React from 'react'
import { useLocation } from 'react-router-dom'

const Notwelcome = () => {
    let data=useLocation();
    let {id}=data.state;
  return (
    <div>
        <h1>This id {id} does not exist</h1>
    </div>
  )
}

export default Notwelcome