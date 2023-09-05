import React, { useState } from 'react';
import axios from 'axios';
import './App.css';
import { IconButton, TextField } from '@mui/material';
import DeleteIcon from '@mui/icons-material/Delete';

function DeleteButton() {
  const [email, setEmail] = useState('');
  const [message, setMessage] = useState('');

  const handleDelete = () => {
    if (!email) {
      setMessage('Please enter an email address.');
      return;
    }

    axios
      .delete(`http://localhost:8080/deleteSignUpById?email=${email}`)
      .then((response) => {
        setMessage('User deleted successfully.');
        // Refresh the page after successful deletion
        window.location.reload();
      })
      .catch((error) => {
        setMessage('An error occurred while deleting the user.');
        // Handle errors here if necessary.
      });
  };

  return (
    <div style={{ display: 'flex', flexDirection: 'column' }}>
      <TextField
        type="text"
        placeholder="ENTER EMAIL"
        value={email}
        style={{ height: '1.5vh', width: '15vw', marginLeft: '8vw' }}
        onChange={(e) => setEmail(e.target.value)}
      />
      <div className='uio' style={{ marginLeft: '19vw' }}>
        <IconButton id='mm' className='uio' onClick={handleDelete} color="secondary">
          <DeleteIcon />
        </IconButton>
      </div>
      <p>{message}</p>
    </div>
  );
}

export default DeleteButton;
