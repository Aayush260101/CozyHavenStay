import React, { useContext } from 'react'
import StudentContext, { studentContext1 } from './StudentContext'

const StudentDetails = () => {
    const {student} = useContext(studentContext1);
  return (
    <div>StudentDetails
        <h1>Name : {student.name}</h1>
        <h1>Fee : {student.fee}</h1>
    </div>
  )
}

export default StudentDetails