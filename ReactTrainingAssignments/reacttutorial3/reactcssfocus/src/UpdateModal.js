import React, { useState } from 'react'
import {
    ModalHeader,
    ModalDescription,
    ModalContent,
    ModalActions,
    Button,
    Header,
    Image,
    Modal,
  } from 'semantic-ui-react'

const UpdateModal = ({updateProduct}) => {
  const [openUpdateModal,setOpenUpdateModal] = useState(false);  
  let [productToUpdate,setProductToUpdate] = useState({id:null,title:"",price:0,category:"",image:""});

  UpdateModal.openUpdateModal = (product) => {
    setProductToUpdate(product);
    setOpenUpdateModal(true);
  };

  const handleUpdate = () => {
    updateProduct(productToUpdate); // Call the function passed from App.js
    setOpenUpdateModal(false); // Close the modal
  };

  return (<>
    <Modal
      onClose={()=>setOpenUpdateModal(false)}
      onOpen={()=>setOpenUpdateModal(true)}
      open={openUpdateModal}
      
    >
    <ModalContent>  
    <div className="div1">
    <input type="text" placeholder="Updated Title" value={productToUpdate.title} onChange={(event)=>setProductToUpdate({...productToUpdate,title:event.target.value})}/>
        <input type="text" placeholder="Updated Price" value={productToUpdate.price} onChange={(event)=>setProductToUpdate({...productToUpdate,price:parseFloat(event.target.value)})}/>
        <input type="text" placeholder="Updated Category" value={productToUpdate.category} onChange={(event)=>setProductToUpdate({...productToUpdate,category:event.target.value})}/>
        <input type="text" placeholder="Updated Image" value={productToUpdate.image} onChange={(event)=>setProductToUpdate({...productToUpdate,image:event.target.value})}/>
    </div>
    </ModalContent>
    <ModalActions>
    <button onClick={handleUpdate}>Update Product</button>
    <button onClick={()=>setOpenUpdateModal(false)}>Cancel</button>
    </ModalActions>
    
    </Modal>
    </>
    
  )
}

export default UpdateModal