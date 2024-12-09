import React from 'react'
import { Link } from 'react-router-dom'
import "./Menu.css"

const Menu = () => {
  return (
    <div>
        <ul>
            <Link to="/"><li>Home</li></Link>
            <Link to="/about"><li>About</li></Link>
            <Link to="/faq"><li>FAQ</li></Link>
            <Link to="/signin"><button>SignIn</button></Link>
            <Link to="/payslip"><li>PaySlip</li></Link>
            <Link to="/contactus"><li>ContactUs</li></Link>
            
            
        </ul>
        
    </div>
  )
}

export default Menu