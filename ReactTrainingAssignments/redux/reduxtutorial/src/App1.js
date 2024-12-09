import React from 'react'
import StudentForm from './StudentForm'
import StudentDetails from './StudentDetails'
import StudentContext from './StudentContext'

const App1 = () => {
  return (
    <StudentContext>App1
        <StudentForm />
        <StudentDetails />
    </StudentContext>
  )
}

export default App1