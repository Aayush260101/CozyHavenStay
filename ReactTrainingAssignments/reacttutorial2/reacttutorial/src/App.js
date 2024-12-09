import React, { useEffect, useState } from 'react'
import Card from './Card';
import "./App.css"

const App=()=> {
  let [products,setProducts]=useState([]);
  let [sproducts,setSproducts]=useState([]);
  let [search,setSearch]=useState("");
  let [title,setTitle]=useState("");
  let [price,setPrice]=useState(0);
  let [image,setImage]=useState("");
  let [description,setDescription]=useState("");
  let [category,setCategory]=useState("");

  useEffect(()=>setSproducts(products.filter((temp)=>temp.title.toLowerCase().includes(search.toLowerCase()) || temp.category.toLowerCase().includes(search.toLowerCase()) || temp.price.toString().includes(search))),[search])

  useEffect(()=>{
    fetch("https://fakestoreapi.com/products")
    .then((res)=>res.json())
    .then(temp=>setProducts(temp))
    .catch((e)=>console.log("Error"))
  },[])

  const addItem=()=>{
    let item={title,price,description,category,image}
    setProducts([item,...products]);
  }

  const removeItem=(id)=>{
    setProducts(products.filter((temp)=>temp.id!=id))
  }

  const updateItem=(id,newprice)=>{
    setProducts(products.map((temp)=>temp.id===id?{...temp,price:newprice} : temp))
  }







  return (<>
    <input className="search-box" type="text" placeholder="Enter Product Name" onChange={(event)=>setSearch(event.target.value)}/>
    <div className="div1">
    <input className="search-box" type="text" placeholder="Enter Product Name" onChange={(event)=>setTitle(event.target.value)}/>
    <input className="search-box" type="text" placeholder="Enter Product Price" onChange={(event)=>setPrice(parseFloat(event.target.value))}/>
    <input className="search-box" type="text" placeholder="Enter Product Image Url" onChange={(event)=>setImage(event.target.value)}/>
    <input className="search-box" type="text" placeholder="Enter Product Description" onChange={(event)=>setDescription(event.target.value)}/>
    <input className="search-box" type="text" placeholder="Enter Product Category" onChange={(event)=>setCategory(event.target.value)}/>
    <button onClick={addItem}>Add New Item</button>
    </div>
    <div className="main">
      {
        search.length>0 ? 
        sproducts.map((temp)=><Card title={temp.title} price={temp.price} description={temp.description} id={temp.id} category={temp.category} image={temp.image}  removeData={removeItem} updateData={updateItem}/>)
        :
        products.map((temp)=><Card title={temp.title} price={temp.price} description={temp.description} id={temp.id} category={temp.category} image={temp.image}  removeData={removeItem} updateData={updateItem}/>)
      } 

    </div>
    </>
  )
}

export default App






// import './App.css';
// import Card from './Card';

// import { useEffect, useState } from 'react';

// const App=()=>{
//   let [search,setSearch]=useState("");
//   let [fheroes,setFheroes]=useState([]);

//   const [users,setUsers]=useState([]);


//   useEffect(()=>setFheroes(users.filter((temp)=>temp.title.includes(search))),[search]);

//   useEffect(()=>{
//     fetch("https://fakestoreapi.com/products")
//     .then((res)=>res.json())
//     .then((temp)=>setUsers(temp))
//     .catch((err)=>console.log("Error"))
//   },[])

  

  

  
  
//   return (<>
//     <input className="search-box" type="text" placeholder="Search by name" onChange={(e)=>setSearch(e.target.value)}></input>
//     <div className="main">
      
//       {
//       search.length>0?
//       fheroes.map((temp) => <Card title={temp.title} price={temp.price} image={temp.image}/>)
//       :
//       users.map((temp) => 
//         <Card title={temp.title} price={temp.price} image={temp.image} />
//       )}
//     </div>
//     </>
//   );
// };



// export default App;

