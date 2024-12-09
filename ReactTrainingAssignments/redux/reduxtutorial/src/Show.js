import React, { useContext } from 'react'
import { MyContext } from './MyContext'

const Show = () => {
    let {name,roll}= useContext(MyContext)
  return (
    <div>Show
        <h1>{roll}  {name}</h1>
    </div>
  )
}

export default Show