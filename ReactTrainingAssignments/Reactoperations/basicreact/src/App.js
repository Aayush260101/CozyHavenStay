import React, { useEffect, useState } from 'react'
import Card from './Card'

const App = () => {

  let [products,setProducts] = useState([]);
  let [sproducts,setSproducts] = useState([]);
  let [search,setSearch] = useState("");
  let [title,setTitle] = useState("");
  let [price,setPrice] = useState(0);
  let [category,setCategory] = useState("");
  let [imageURL,setImageURL] = useState("");
  let [isUpdating,setIsUpdating] = useState(false);
  let [productToUpdate,setProductToUpdate] = useState({id:null,title:"",price:0,category:"",image:""});

  useEffect(()=>{setSproducts(products.filter((temp)=>(temp.title.includes(search))))},[search])

  useEffect(()=>{
    fetch("https://fakestoreapi.com/products")
    .then((res)=>res.json())
    .then((res)=>setProducts(res))
    .catch((error)=>console.log("Error"))
  },[])

  const addProduct=()=>{
    let newProduct={title,price,category,imageURL};
    setProducts([newProduct,...products]);
  }

  const deleteProduct=(id)=>{
    const updatedProducts = products.filter((temp) => temp.id !== id);
    setProducts(updatedProducts);
    setSproducts(updatedProducts.filter((temp) => temp.title.includes(search)));
  }

  const startUpdate=(id,title,price,category,image)=>{
    setIsUpdating(true);
    setProductToUpdate({id,title,price,category,image});
  }

  const saveUpdate=()=>{
    const UpdatedProducts=products.map((temp)=>temp.id===productToUpdate.id ? {...productToUpdate} : temp);
    setProducts(UpdatedProducts);
    setSproducts(UpdatedProducts.filter((temp) => temp.title.includes(search)));
    setIsUpdating(false);
  }

  

  return (<>
    <div>
      <input type="text" placeholder="Enter Product Title" onChange={(event)=>setSearch(event.target.value)}/>
      
    </div>
    <div className="div1">
    <input type="text" placeholder="Enter Product Title" onChange={(event)=>setTitle(event.target.value)}/>
    <input type="text" placeholder="Enter Product Price" onChange={(event)=>setPrice(parseFloat(event.target.value))}/>
    <input type="text" placeholder="Enter Product Category" onChange={(event)=>setCategory(event.target.value)}/>
    <input type="text" placeholder="Enter Product Image Link" onChange={(event)=>setImageURL(event.target.value)}/>
    <button onClick={addProduct}>Add Product</button>
    </div>

    <div className="main">
      {
        search.length>0 ?
        sproducts.map((temp)=> <Card title={temp.title} category={temp.category} price={temp.price} image={temp.image} id={temp.id} deleteProduct={deleteProduct} startUpdate={startUpdate}/>)
        :
        products.map((temp)=> <Card title={temp.title} category={temp.category} price={temp.price} image={temp.image} id={temp.id} deleteProduct={deleteProduct} startUpdate={startUpdate}/>)
      }
    </div>
    {
      isUpdating && (<div className="div1">
        <h1>Update Product</h1>
        <input type="text" placeholder="Updated Title" value={productToUpdate.title} onChange={(event)=>setProductToUpdate({...productToUpdate,title:event.target.value})}/>
        <input type="text" placeholder="Updated Price" value={productToUpdate.price} onChange={(event)=>setProductToUpdate({...productToUpdate,price:parseFloat(event.target.value)})}/>
        <input type="text" placeholder="Updated Category" value={productToUpdate.category} onChange={(event)=>setProductToUpdate({...productToUpdate,category:event.target.value})}/>
        <input type="text" placeholder="Updated Image" value={productToUpdate.image} onChange={(event)=>setProductToUpdate({...productToUpdate,image:event.target.value})}/>
        <button onClick={saveUpdate}>Save</button>
        <button onClick={()=>setIsUpdating(false)}>Cancel</button>
      </div>)
    }
    </>
  )
}

export default App