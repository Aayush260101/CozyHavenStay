import React, { useState } from 'react';
import './App.css';

const Card = ({ title, price, description, category, image, id, removeData, updateData }) => {
  const [newprice, setNewprice] = useState(price);
  const [flag, setFlag] = useState(false);

  // Handle price update
  const handlePriceUpdate = () => {
    if (newprice !== price) {
      updateData(id, newprice); // Update price in parent state
    }
    setFlag(false); // Close the input field after updating
  };

  return (
    <div className="div1">
      <h1>Title: {title}</h1>
      <h1>Price: {" "}
        {flag === true ? (
          <div>
            <input
              type="number"
              placeholder="Enter New Price"
              value={newprice}
              onChange={(event) => setNewprice(parseFloat(event.target.value))}
            />
            <button onClick={handlePriceUpdate}>OK</button>
          </div>
        ) : (
          price
        )}
      </h1>
      <h2>Description: {description}</h2>
      <h2>Category: {category}</h2>
      <img alt="" src={image} />
      <button onClick={() => removeData(id)}>Remove</button>

      {flag === true ? (
        <>
          <button onClick={handlePriceUpdate}>Save</button>
          <button onClick={() => setFlag(false)}>Cancel</button>
        </>
      ) : (
        <button onClick={() => setFlag(true)}>Update</button>
      )}
    </div>
  );
};

export default Card;
