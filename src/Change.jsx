import React, { useState } from 'react';
import TextField from '@mui/material/TextField'; 
import Button from '@mui/material/Button'; 
import InputAdornment from '@mui/material/InputAdornment';
import './App.css';
import axios from 'axios';

const UpdateData = ({ handleClose }) => {
  const [name, setName] = useState('');
  const [dob, setDob] = useState('');
  const [gender, setGender] = useState('');
  const [age, setAge] = useState('');
  const [mobile_no, setMobile_no] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [confirm_password, setConfirm_password] = useState('');

  const handleSubmit = (event) => {
    event.preventDefault();
    
    const formData = {
      name,
      dob,
      gender,
      age,
      mobile_no,
      email,
      password,
      confirm_password
    };
    axios.put('http://localhost:8080/putSignUp', formData)
      .then(response => {
        console.log('Data sent successfully:', response.data);
        handleClose();
      })
      .catch(error => {
        console.error('Error sending data:', error);
      });
  };

  return (
    <div>
      <form onSubmit={handleSubmit}>
        <div style={{"paddingBottom":"1vh"}}>
          <TextField
            label="NAME"
            style={{"textAlign":"center"}}
            value={name}
            onChange={(event) => setName(event.target.value)}
            variant="outlined"
            color="primary"
          />
        </div>
        <div style={{"paddingBottom":"1vh"}}>
          <TextField
            label="DATE OF BIRTH"
            variant="outlined"
            color="primary"
            value={dob}
            onChange={(event) => setDob(event.target.value)}
          />
        </div>
        <div style={{"paddingBottom":"1vh"}}>
          <TextField
            label="GENDER"
            variant="outlined"
            color="primary"
            value={gender}
            onChange={(event) => setGender(event.target.value)}
          />
        </div>
        <div style={{"paddingBottom":"1vh"}}>
          <TextField
            label="AGE"
            variant="outlined"
            color="primary"
            value={age}
            onChange={(event) => setAge(event.target.value)}
          />
        </div>
        <div style={{"paddingBottom":"1vh"}}>
          <TextField
            label="MOBILE"
            variant="outlined"
            color="primary"
            value={mobile_no}
            onChange={(event) => setMobile_no(event.target.value)}
          />
        </div>
        <div style={{"paddingBottom":"1vh"}}>
          <TextField
            label="EMAIL"
            variant="outlined"
            color="primary"
            value={email}
            onChange={(event) => setEmail(event.target.value)}
          />
        </div>
        <div style={{"paddingBottom":"1vh"}}>
          <TextField
            label="PASSWORD"
            variant="outlined"
            color="primary"
            value={password}
            onChange={(event) => setPassword(event.target.value)}
          />
        </div>
        <div style={{ "paddingBottom": "1vh" }}>
          <TextField
            label="CONFIRM PASSWORD"
            style={{"textAlign":"center"}}
            variant="outlined"
            color="primary"
            value={confirm_password}
            onChange={(event) => setConfirm_password(event.target.value)}
          />
        </div>

        <div id='formsubmit' style={{"textAlign":"center"}}>
          <Button color="inherit" variant="contained" id='btt' role="button" type="submit" >
            SAVE
          </Button>
        </div>
      </form>
    </div>
  );
};

export default UpdateData;
