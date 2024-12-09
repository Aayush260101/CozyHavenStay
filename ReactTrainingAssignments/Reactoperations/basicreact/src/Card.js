import React from 'react'
import "./App.css"

const Card = ({title,category,price,image,id,deleteProduct,startUpdate}) => {
  return (<>
    <div className="div1">
        <h1>Title : {title}</h1>
        <h2>Category : {category}</h2>
        <h2>Price : {price}</h2>
        <img src={image} alt=""/>
        <button onClick={()=>deleteProduct(id)}>Delete</button>
        <button onClick={()=>startUpdate(id,title,price,category,startUpdate)}>Update</button>
    </div>
    </>
  )
}

export default Card