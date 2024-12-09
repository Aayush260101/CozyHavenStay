import React, { useState } from "react";
import "./App.css";
import Updatepass from "./updatepass";

const Localstorage = () => {
  const [id, setId] = useState("");
  const [pass, setPass] = useState("");
  const [email, setEmail] = useState("");
  const [showUpdate, setShowUpdate] = useState(false); // Controls visibility of Updatepass

  const handleId = (event) => {
    setId(event.target.value);
  };

  const handlePass = (event) => {
    setPass(event.target.value);
  };

  const handleEmail = (event) => {
    setEmail(event.target.value);
  };

  const setValues = () => {
    const data = { id, pass, email };
    localStorage.setItem(id, JSON.stringify(data));
    alert("Account Created");
  };

  const getValues = () => {
    const data = JSON.parse(localStorage.getItem(id));
    if (!data) {
      alert("Invalid UserID");
      return;
    }
    if (data.pass === pass) {
      alert("Successful SignIn");
    } else {
      alert("Invalid Password");
    }
  };

  const update = () => {
    // Show the Updatepass component
    setShowUpdate(true);
  };

  const deleteValues = () => {
    localStorage.removeItem(id);
    alert("Delete Successful");
  };

  const handleUpdateComplete = (newPassword) => {
    const data = JSON.parse(localStorage.getItem(id));
    if (data) {
      data.pass = newPassword;
      localStorage.setItem(id, JSON.stringify(data));
      alert("Password Updated Successfully");
    } else {
      alert("Invalid UserID");
    }
    setShowUpdate(false); // Return to the main Localstorage form
  };

  return (
    <div className="div1">
      {showUpdate ? (
        // Render Updatepass when showUpdate is true
        <Updatepass id={id} onUpdateComplete={handleUpdateComplete} />
      ) : (
        // Render Localstorage form
        <>
          <input type="text" placeholder="Enter UserID" onChange={handleId} />
          <input type="text" placeholder="Enter Password" onChange={handlePass} />
          <input type="email" placeholder="Enter Email" onChange={handleEmail} />

          <button onClick={getValues}>SignIn</button>
          <button onClick={setValues}>SignUp</button>
          <button onClick={update}>Update</button>
          <button onClick={deleteValues}>Remove</button>
        </>
      )}
    </div>
  );
};

export default Localstorage;
