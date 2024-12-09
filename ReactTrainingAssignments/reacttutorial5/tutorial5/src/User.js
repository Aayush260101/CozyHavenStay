import React from 'react'
import { useParams } from 'react-router-dom'

const User = () => {
    let {nm}=useParams()
  return (
    <div>Welcome {nm}</div>
  )
}

export default User