import React, { useState } from "react";

const Updatepass = ({ id, onUpdateComplete }) => {
  const [newPassword, setNewPassword] = useState("");

  // Handles password input
  const handlePasswordChange = (event) => {
    setNewPassword(event.target.value);
  };

  // Updates password and notifies parent
  const handleUpdate = () => {
    if (!newPassword) {
      alert("Please enter a new password");
      return;
    }
    onUpdateComplete(newPassword); // Trigger parent update logic
  };

  return (
    <div className="div1">
      <h1>Update Password</h1>
      <input
        type="text"
        placeholder="Enter New Password"
        onChange={handlePasswordChange}
      />
      <button onClick={handleUpdate}>Update</button>
    </div>
  );
};

export default Updatepass;
