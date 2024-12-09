import React from 'react';
import { Modal, Button } from 'semantic-ui-react';

const ConfirmDeleteModal = ({ open, setOpen, bookToDelete, deleteBook }) => {

  const handleConfirm = () => {
    deleteBook(bookToDelete);
    setOpen(false); // Close the modal after deletion
  };

  const handleClose = () => {
    setOpen(false); // Close the modal if canceled
  };

  return (
    <Modal size="tiny" open={open} onClose={handleClose}>
      <Modal.Header>Confirm Deletion</Modal.Header>
      <Modal.Content>
        <p>Are you sure you want to delete this book?</p>
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
