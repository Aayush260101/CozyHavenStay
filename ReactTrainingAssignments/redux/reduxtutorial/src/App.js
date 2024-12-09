import React, { useState } from 'react'
import { MyContext } from './MyContext';
import Show from './Show';

const App = () => {

  let [name,setName] = useState("Aayush");
  let [roll,setRoll] = useState(1);
  return (
    <div>App
      <MyContext.Provider value={{name,roll}}>
        <Show />
      </MyContext.Provider>
    </div>
  )
}

export default App;