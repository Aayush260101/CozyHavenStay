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

const AddModal = ({addProduct}) => {
  const [open,setOpen] = useState(false);  
  let [title,setTitle] = useState("");
  let [price,setPrice] = useState(0);
  let [description,setDescription] = useState("");
  let [imageURL,setImageURL] = useState("");

  const handleAddProduct=()=>{
    const newProduct = {
         
        title,
        price: parseFloat(price),
        description,
        image: imageURL,
      };
      addProduct(newProduct); 
      setOpen(false);
      setTitle(""); 
      setPrice("");
      setDescription("");
      setImageURL("");
  }
  return (<>
    <Modal
      onClose={()=>setOpen(false)}
      onOpen={()=>setOpen(true)}
      open={open}
      trigger={<Button>Add Product</Button>}
    >
    <ModalContent>  
    <div className="div1">
    <input type="text" placeholder="Enter Product Title" onChange={(event)=>setTitle(event.target.value)}/>
    <input type="text" placeholder="Enter Product Price" onChange={(event)=>setPrice(parseFloat(event.target.value))}/>
    <input type="text" placeholder="Enter Product Description" onChange={(event)=>setDescription(event.target.value)}/>
    <input type="text" placeholder="Enter Product Image Link" onChange={(event)=>setImageURL(event.target.value)}/>
    </div>
    </ModalContent>
    <ModalActions>
    <button onClick={handleAddProduct}>Add Product</button>
    <button onClick={()=>setOpen(false)}>Cancel</button>
    </ModalActions>
    
    </Modal>
    </>
    
  )
}

export default AddModal