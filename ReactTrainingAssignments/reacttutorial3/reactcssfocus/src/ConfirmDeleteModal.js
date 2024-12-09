import React, { useState } from 'react';
import { Modal, Button } from 'semantic-ui-react';

const ConfirmDeleteModal = ({ deleteProduct }) => {
  const [open, setOpen] = useState(false); 
  const [productToDelete, setProductToDelete] = useState(null); 

  
  ConfirmDeleteModal.openDeleteModal = (id) => {
    setProductToDelete(id); 
    setOpen(true); 
  };

  const handleConfirm = () => {
    deleteProduct(productToDelete); 
    setOpen(false); 
    setProductToDelete(null); 
  };

  const handleClose = () => {
    setOpen(false);
    setProductToDelete(null); 
  };

  return (
    <Modal size="tiny" open={open} onClose={handleClose}>
      <Modal.Header>Confirm Deletion</Modal.Header>
      <Modal.Content>
        <p>Are you sure you want to delete this product?</p>
      </Modal.Content>
      <Modal.Actions>
        <Button onClick={handleClose} negative>
          Cancel
        </Button>
        <Button onClick={handleConfirm} positive>
          Delete
        </Button>
      </Modal.Actions>
    </Modal>
  );
};

export default ConfirmDeleteModal;
