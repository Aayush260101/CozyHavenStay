import React, { useEffect, useState } from 'react';
import Pcard from './Pcard';
import Render from './Render';
import AddModal from './AddModal';
import ConfirmDeleteModal from './ConfirmDeleteModal';
import UpdateModal from './UpdateModal';
import { message } from 'antd';
import "./App.css"

const App = () => {
  const [products, setProducts] = useState([]);
  const [flag, setFlag] = useState(false);

  useEffect(() => {
    fetch('https://fakestoreapi.com/products')
      .then((res) => res.json())
      .then((temp) => {
        setProducts(temp);
        setFlag(true);
      })
      .catch(() => console.log('Error fetching data'));
  }, []);

  const deleteProduct = (id) => {
    // Removes the product from the list
    setProducts(products.filter((temp) => temp.id !== id));
    message.success('Product Deleted!',5);
  };

  const updateProduct=(productToUpdate)=>{
    const UpdatedProducts=products.map((temp)=>temp.id===productToUpdate.id ? {...productToUpdate} : temp);
    setProducts(UpdatedProducts); 
  }

  return (
    <>
      <AddModal addProduct={(newProduct) => setProducts([newProduct, ...products])} />

      <div className="card-container">
        {flag === false ? (
          <Render />
        ) : products.length ? (
          products.map((temp) => (
            <Pcard
              key={temp.id}
              id={temp.id}
              title={temp.title}
              description={temp.description}
              price={temp.price}
              image={temp.image}
              deleteProduct={() => ConfirmDeleteModal.openDeleteModal(temp.id)}
              updateProduct={()=>UpdateModal.openUpdateModal(temp)}
            />
          ))
        ) : (
          <p>No Products Available</p>
        )}
      </div>

      
      <ConfirmDeleteModal
        deleteProduct={deleteProduct} 
      />
      <UpdateModal
       updateProduct={updateProduct}
      />
    </>
  );
};

export default App;
