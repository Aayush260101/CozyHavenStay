import React from 'react'
import Faq from './Faq'
import About from './About'
import Home from './Home'
import { Route, Routes } from "react-router-dom";
import Login from './Login';
import Welcome from './Welcome';
import Notwelcome from './Notwelcome';
import PaySlip from './PaySlip';
import Display from './Display';
import Welcome1 from './Welcome1';
import User from './User';
import Protected from './Protected';
import ContactUs from './ContactUs';
import Email from './Email';
import Phone from './Phone';

const Routing = () => {
  return (<>

  <Routes>

    <Route path="/" element={<Home/>}/>
    <Route path="/about" element={<About/>}/>
    <Route path="/faq" element={<Faq/>}/>
    <Route path="/signin" element={<Login/>}/>
    <Route path="/welcome" element={<Welcome/>}/>
    <Route path="/notwelcome" element={<Notwelcome/>}/>
    
    <Route path="/display" element={<Display/>}/>
    <Route path="/welcome1" element={<Welcome1/>}/>
    <Route path="/user/:nm" element={<User/>}/>
    <Route path="/payslip" element={<Protected Component={PaySlip}/>}/>
    <Route path="/contactus" element={<ContactUs/>}>
        <Route path="email" element={<Email/>}/>
        <Route path="phone" element={<Phone />}/>
    </Route>

  </Routes>
  
    
    </>
  )
}

export default Routing