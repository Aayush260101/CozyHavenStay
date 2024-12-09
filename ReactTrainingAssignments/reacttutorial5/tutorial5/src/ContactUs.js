import React from 'react'
import { Link, Outlet } from 'react-router-dom'

const ContactUs = () => {
  return (
    <div>ContactUs : You can reach out to us via - 
        <nav>
            <Link to="email"><li>Emails</li></Link>
            <Link to="phone"><li>Phone</li></Link>
        </nav>
        <Outlet />
    </div>
  )
}

export default ContactUs