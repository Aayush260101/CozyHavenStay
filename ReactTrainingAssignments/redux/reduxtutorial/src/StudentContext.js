import React, { createContext, useState } from 'react'

export const studentContext1=createContext();

const StudentContext = ({children}) => {
    const [student,setStudent] = useState({name:"",fee:0});
  return (
    <div>StudentContext
        <studentContext1.Provider value={{student,setStudent}}>
            {children}
        </studentContext1.Provider>
    </div>
  )
}

export default StudentContext