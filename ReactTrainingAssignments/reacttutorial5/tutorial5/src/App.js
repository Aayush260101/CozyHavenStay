import React, { useState } from 'react'

import Routing from './Routing'
import Menu from './Menu'
import { Link } from 'react-router-dom'


const App = () => {
  let [users,setUsers] = useState(["Aayush","Aman","Ashu","Shalini","Ayush"]);
  return (
    <div>
      <Menu/>
      <Routing/>
      {
        users.map((temp)=> <Link to={`/user/${temp}`}><h2>{temp}</h2></Link>)
      }
      <Link to="/user/aayush"><li>Aayush</li></Link>
      <Link to="/user/aman"><li>Aman</li></Link>
      
      
      
    </div>
  )
}

export default App