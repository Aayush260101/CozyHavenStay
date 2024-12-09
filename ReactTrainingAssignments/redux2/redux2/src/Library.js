import React from 'react'
import { useSelector } from 'react-redux'

const Library = () => {
    let {DSA,JAVA,JavaScript,DBMS,OS} = useSelector((state)=>state)
  return (
    <div>Library Component
        <h1>DSA : {DSA}</h1>
        <h1>JAVA : {JAVA}</h1>
        <h1>JavaScript : {JavaScript}</h1>
        <h1>DBMS : {DBMS}</h1>
        <h1>OS : {OS}</h1>
    </div>
  )
}

export default Library