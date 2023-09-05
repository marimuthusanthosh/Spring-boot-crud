import React, { useState } from 'react';
import './App.css';
import Form from './Form';
import Product from './Products';
import DeleteButton from './DeleteDialog';
import UpdateData from './Change';
import { Button, Dialog, DialogTitle, DialogContent, DialogActions, IconButton, TextField } from '@mui/material';
import DeleteIcon from '@mui/icons-material/Delete';
import EditIcon from '@mui/icons-material/Edit';
import AboutUs from './About';
import axios from 'axios'; // Import axios for making API requests
import ArrowBackIcon from '@mui/icons-material/ArrowBack';

export default function Heading() {
  const [open, setOpen] = useState(false);
  const [userSignedIn, setUserSignedIn] = useState(false);
  const [showProduct, setShowProduct] = useState(false);
  const [deleteDialogOpen, setDeleteDialogOpen] = useState(false);
  const [updateDialogOpen, setUpdateDialogOpen] = useState(false);
  const [aboutOpen, setAboutOpen] = useState(false);
  const [email, setEmail] = useState(''); // State for email input
  const [password, setPassword] = useState(''); // State for password input
  const [signInDialogOpen, setSignInDialogOpen] = useState(false);

  const handleOpen = () => {
    setOpen(true);
  };

  const handleClose = () => {
    setOpen(false);
  };

  const handleFormSubmit = () => {
    setUserSignedIn(true);
  };

  const handleSignOut = () => {
    setUserSignedIn(false);
    window.location.reload(); // Refresh the page
  };  

  const handleDeleteOpen = () => {
    setDeleteDialogOpen(true);
  };

  const handleDeleteClose = () => {
    setDeleteDialogOpen(false);
  };

  const handleUpdateOpen = () => {
    setUpdateDialogOpen(true);
  };

  const handleUpdateClose = () => {
    setUpdateDialogOpen(false);
  };

  const handleAboutToggle = () => {
    setAboutOpen(!aboutOpen);
  };

  const handleSignInDialogOpen = () => {
    setSignInDialogOpen(true);
  };
  
  const handleSignInDialogClose = () => {
    setSignInDialogOpen(false);
  };
  
  const handleSignIn = () => {
    // Make a GET request to check email and password
    axios
      .get(`http://localhost:8080/querySignUp?email=${email}&password=${password}`)
      .then((response) => {
        const isValidSignIn = response.data.length > 0; // Check if there's at least one matching record
        if (isValidSignIn) {
          console.log(isValidSignIn); // Use console.log to print the result
          setUserSignedIn(true);
          setEmail(''); // Clear the email input
          setPassword(''); // Clear the password input
        } else {
          // Handle invalid sign-in
          alert('Invalid email or password. Please try again.'); // Uncomment this line to show an alert message
        }
      })
      .catch((error) => {
        // Handle API error
        console.error('Error checking sign-in:', error);
      });
  };
  

  return (
    <div style={{ "paddingBottom": "20vh", "paddingLeft": "5vw", "paddingTop": "2.3vh" }}>
      <header className="Navbar">
        <div id='top1'>
          <div id='m'>L</div>
          <div id='p'>IFE</div>
          <div id='d'>I</div>
          <div id='o'>NSURANCE</div>
          <div id='top1' style={{ "paddingLeft": "20.5vw", "paddingBottom": "1.7vh" }}>
            <div>
              <Button id='hh' variant="contained" onClick={handleAboutToggle}>
                ABOUT
              </Button>
            </div>
            <div>
              <Button id='hh' variant="contained">
                RENEW YOUR POLICY
              </Button>
            </div>
            {!userSignedIn ? (
              <>
                <div>
                  <Button id='hh' variant="contained" onClick={handleOpen}>
                    SIGN UP
                  </Button>
                </div>
              <div>
              <Button id='hh' variant="contained" onClick={handleSignInDialogOpen}>
                SIGN IN
              </Button>
            </div>

              </>
            ) : (
              <div>
              <Button id='hh' variant="contained" onClick={() => setShowProduct(!showProduct)}>
                PRODUCTS
              </Button>
                <Button id="so" color="secondary" variant="contained" onClick={handleSignOut}>
                  SIGN OUT
                </Button>
                <IconButton className='uio' id="edit" style={{ "marginLeft": "1vw" }} variant="contained" onClick={handleUpdateOpen}>
                  <EditIcon />
                </IconButton>
                <IconButton className='uio' id="delete" style={{ "marginLeft": "1vw" }} variant="contained" onClick={handleDeleteOpen}>
                  <DeleteIcon />
                </IconButton>
              </div>
            )}
          </div>
        </div>
      </header>
      <Dialog
        open={open}
        onClose={handleClose}
        PaperProps={{
          style: {
            maxWidth: '35vw',
            width: '80vw',
            textAlign: 'center',
            boxShadow: '0px 0px 25px rgba(0, 0, 0, 0.5)',
          },
        }}
      >
        <DialogTitle><div id='mmm'>DETAILS</div></DialogTitle>
        <DialogContent>
          <Form handleClose={handleClose} handleFormSubmit={handleFormSubmit} />
        </DialogContent>
      </Dialog>
      <Dialog
        open={signInDialogOpen}
        onClose={handleSignInDialogClose}
        PaperProps={{
          style: {
            maxWidth: '25vw',
            width: '50vw',
            textAlign: 'center',
            boxShadow: '0px 0px 25px rgba(0, 0, 0, 0.5)',
          },
        }}
      >
        <DialogTitle>
          <div id='mmm' >SIGN IN</div>
        </DialogTitle>
        <DialogContent>
          <div style={{"paddingTop":"2vh"}}>
          <TextField
            id="email-input"
            label="EMAIL"
            variant="outlined"
            value={email}
            onChange={(event) => setEmail(event.target.value)}
          />
          </div>
          <div style={{"marginTop":"3vh"}}>
            <TextField
            id="password-input"
            label="PASSWORD"
            type="password"
            variant="outlined"
            value={password}
            onChange={(event) => setPassword(event.target.value)}
          />
          </div>
        </DialogContent>
        <DialogActions style={{"marginRight":"5.4vw"}} >
          <div style={{"margiRight":"5vw"}}><Button id='mm' onClick={handleSignInDialogClose} color="primary">
            CANCEL
          </Button></div>
          <div><Button onClick={() => {
            handleSignIn();
            handleSignInDialogClose(); // Close the dialog after signing in
          }} color="inherit" variant="contained">
            LET'S GO
          </Button></div>
        </DialogActions>
      </Dialog>

      {aboutOpen && (
        <div className="about-details">
          <AboutUs />
        </div>
      )}
      <div style={{ "marginLeft": "3vw", "marginTop": "12vh" }}>{showProduct && <Product />}</div>
      <Dialog
        open={deleteDialogOpen}
        onClose={handleDeleteClose}
        PaperProps={{
          style: {
            maxWidth: '35vw',
            width: '80vw',
            textAlign: 'center',
            boxShadow: '0px 0px 25px rgba(0, 0, 0, 0.5)',
          },
        }}
      >
        <DialogTitle>
          <div id='mmm'>CONFIRM DELETE</div>
        </DialogTitle>
        <DialogContent>
          <p className='ui'>Are you sure you want to delete your account?</p>
          <DeleteButton />
        </DialogContent>
        <DialogActions>
        <Button id='mm' onClick={handleDeleteClose} color="primary">
        <ArrowBackIcon />
        </Button>

        </DialogActions>
      </Dialog>
      {/* UPDATE Dialog */}
      <Dialog
        open={updateDialogOpen}
        onClose={handleUpdateClose}
        PaperProps={{
          style: {
            maxWidth: '35vw',
            width: '80vw',
            textAlign: 'center',
            boxShadow: '0px 0px 25px rgba(0, 0, 0, 0.5)',
          },
        }}
      >
        <DialogTitle>
          <div id='mm'>UPDATES</div>
        </DialogTitle>
        <DialogContent>
          <UpdateData />
        </DialogContent>
      </Dialog>
    </div>
  );
}