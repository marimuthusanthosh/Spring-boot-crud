
import React, { useState, useEffect } from 'react'; 


import axios from 'axios';
import {
  Card,
  CardContent,
  CardActions,
  Button,
  Typography,
  TextField,
  Dialog,
  DialogActions,
  DialogContent,
  DialogTitle,
} from '@mui/material';
import './App.css';

const PolicyList = () => {  
  const [policies, setPolicies] = useState([]);
  const [isLoading, setIsLoading] = useState(true); 
  const handleBuyClick = () => {
  };

  useEffect(() => {

    axios.get('http://localhost:8080/showPolicy')
      .then(response => {
        setPolicies(response.data);
        setIsLoading(false); 
      })
      .catch(error => {
        console.error('Error fetching policies:', error);
        setIsLoading(false);
      });
  }, []);

  const InsuranceCard = ({ policy }) => {
    return (
        <Card variant="outlined">
          <CardContent>
            <div style={{ textAlign: "center" }}>
              <Typography variant="h6" component="div" id="pol">
                {policy.name} - UIN: {policy.uin}
              </Typography>
            </div>
            <Typography color="textSecondary">
              <div className="names">Policy Number: {policy.p_number}</div>
            </Typography>
            <Typography color="textSecondary">
              <div className="names">
                Age Range: {policy.min_age} - {policy.max_age}
              </div>
            </Typography>
            <Typography color="textSecondary">
              <div className="names">Annual Income: {policy.annual_income}</div>
            </Typography>
            <Typography color="textSecondary">
              <div className="names">NRI: {policy.nri}</div>
            </Typography>
          </CardContent>
          <CardActions style={{"textAlign":"center"}}>
            <div style={{ textAlign: "center" }}>
              <Button
                variant="contained"
                size="small"
                className="ui"
                onClick={handleBuyClick}
                style={{"marginLeft":"12.73vw","marginBottom":"2vh"}}
              >
                BUY
              </Button>
            </div>
          </CardActions>
        </Card>
      );
    };

  return (
    <div>
      {isLoading ? (
        <Typography>Loading policies...</Typography>
      ) : (
        policies.map((policy) => (
          <InsuranceCard key={policy.uin} policy={policy} />
        ))
      )}
    </div>
  );
};

const Product = () => {
  const [isAddingPolicy, setIsAddingPolicy] = useState(false);
  const [newPolicy, setNewPolicy] = useState({
    name: '',
    p_number: '',
    uin: '',
    min_age: '',
    max_age: '',
    annual_income: '',
    nri: '',
  });
  const [isDisplayingPolicies, setIsDisplayingPolicies] = useState(false);
  const [isDeletingPolicy, setIsDeletingPolicy] = useState(false);
  const [uinToDelete, setUinToDelete] = useState('');
  const handleAddPolicy = () => {
    setIsAddingPolicy(true);
    setIsDisplayingPolicies(false);
    setIsDeletingPolicy(false);
  };

  const handleDisplayPolicies = () => {
    setIsDisplayingPolicies(true);
    setIsAddingPolicy(false);
    setIsDeletingPolicy(false);
  };

  const handleCloseDialog = () => {
    setIsAddingPolicy(false);
    setIsDisplayingPolicies(false);
    setNewPolicy({
      name: '',
      p_number: '',
      uin: '',
      min_age: '',
      max_age: '',
      annual_income: '',
      nri: '',
    });
  };

  const handlePolicyChange = (event) => {
    const { name, value } = event.target;
    setNewPolicy((prevPolicy) => ({
      ...prevPolicy,
      [name]: value,
    }));
  };

const handleAddPolicySubmit = () => {
  console.log('New policy data:', newPolicy);
  axios
    .post('http://localhost:8080/addPolicy', newPolicy)
    .then((response) => {
      console.log('New policy added:', response.data);
      handleCloseDialog();
    })
    .catch((error) => {
      console.error('Error adding policy:', error);
    });
};

  return (
    <div style={{ "textAlign":"center","paddingRight":"10vw"}}>
        <div>

      <Typography variant="h4" gutterBottom >
       <div className="lk"> PRODUCTS</div>
      </Typography>
        </div>

      <Card sx={{maxWidth:800}} style={{"height":"42vh","width":"70vw","marginLeft":"15vw","backgroundColor":"#DDE6ED"}}>
            <p className='cdd'>
            Adding a new policy is a straightforward process that allows you to expand your insurance offerings. In our system, you can click on the "ADD POLICY" button to initiate the policy creation process. This action opens a dialog where you can input all the necessary details for the new policy, such as the policy holder's name, policy number, UIN (Unique Identification Number), minimum and maximum age range for eligibility, annual income criteria, and whether the policy is applicable to NRIs (Non-Resident Indians). Once you've filled out these fields, click the "Add Policy" button to submit the information. Our system will then process the data, and the new policy will become available for purchase. This streamlined approach ensures that you can efficiently introduce and manage a wide range of insurance policies to meet your customers' needs.
            </p>
      <Button variant="contained" id='btt' color="primary" onClick={handleAddPolicy} style={{"marginTop":"2vh","marginBottom":"1vh"}}>ADD POLICY</Button>
      </Card>
     

      {isAddingPolicy && (
          <Dialog open={isAddingPolicy} onClose={handleCloseDialog} >
          <DialogTitle style={{"textAlign":"center"}}><div id='but'>ADD NEW POLICY</div></DialogTitle>
          <DialogContent>
            <TextField id='ytt' label="NAME" style={{"marginBottom":"2.5vh"}} name="name" value={newPolicy.name} onChange={handlePolicyChange} fullWidth />
            <TextField id='ytt' label="POLICY NUMBER" style={{"marginBottom":"2.5vh"}} name="p_number" value={newPolicy.p_number} onChange={handlePolicyChange} fullWidth />
            <TextField id='ytt' label="UIN" name="uin" style={{"marginBottom":"2.5vh"}} value={newPolicy.uin} onChange={handlePolicyChange} fullWidth />
            <TextField id='ytt' label="MINIMUM AGE" style={{"marginBottom":"2.5vh"}} name="min_age" value={newPolicy.min_age} onChange={handlePolicyChange} fullWidth />
            <TextField id='ytt' label="MAXIMUM AGE" style={{"marginBottom":"2.5vh"}} name="max_age" value={newPolicy.max_age} onChange={handlePolicyChange} fullWidth />
            <TextField id='ytt' label="ANNUAL INCOME" style={{"marginBottom":"2.5vh"}} name="annual_income" value={newPolicy.annual_income} onChange={handlePolicyChange} fullWidth />
            <TextField id='ytt' label="NRI" name="nri" style={{"marginBottom":"2.5vh"}} value={newPolicy.nri} onChange={handlePolicyChange} fullWidth />
          </DialogContent>
          <DialogActions>
            <Button onClick={handleCloseDialog} id='btt' >
              <div className='uio'>CANCEL</div>
            </Button>
            <Button onClick={handleAddPolicySubmit} id='btt' color="primary">
              ADD POLICY
            </Button>
          </DialogActions>
        </Dialog>
      )}

      
{isDisplayingPolicies && (
  <Dialog
    open={isDisplayingPolicies}
    onClose={handleCloseDialog}
    PaperProps={{
        style: {
          maxWidth: '35vw',
          width: '80vw',
          textAlign: 'center',
          boxShadow: '0px 0px 25px rgba(0, 0, 0, 0.5)', 
        },
      }}
  >
    <DialogTitle style={{ textAlign: 'center' }}>
      <div className='kkl'> AVAILABLE POLICIES</div>
    </DialogTitle>
    <DialogContent style={{ marginTop: "3vh" }}>
      <PolicyList />
    </DialogContent>
    <DialogActions>
      <Button onClick={handleCloseDialog} id="btt">
        <div className="uio">CANCEL</div>
      </Button>
    </DialogActions>
  </Dialog>
)}

      <div >
      <Card sx={{maxWidth:800}} style={{"height":"35vh","width":"70vw","marginLeft":"15vw","marginTop":"5vh","backgroundColor":"#DDE6ED","marginBottom":"1vh"}} variant="outlined" >  
      <div>
        <div>
            <p className='cdd'>
                 Displaying and purchasing policies is a user-friendly and engaging experience in our system, designed to pique your curiosity and make the process effortless. When you click on the "DISPLAY POLICIES" button, a comprehensive list of available policies instantly appears on your screen. Each policy card provides essential details such as the policy name, UIN (Unique Identification Number), policy number, age eligibility range, annual income criteria, and whether it's suitable for NRIs (Non-Resident Indians). This organized presentation allows you to explore a variety of insurance options quickly.
            </p>
        </div>
        </div>
      <Button variant="contained" id='btt' color="primary" onClick={handleDisplayPolicies} style={{"marginTop":"2vh"}}> DISPLAY POLICIES</Button>
      </Card>
      </div>
    </div>
  );
};

export default Product;
