import React from 'react'
import WebContext from './WebContext'
import WebForm from './WebForm'
import WebDetails from './WebDetails'

const App2 = () => {
  return (
    <div>
        <WebContext>
            <WebForm />
             <WebDetails />
        </WebContext>
    </div>
  )
}

export default App2