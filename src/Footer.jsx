import React from 'react';
import { styled } from '@mui/material/styles';
import { Container, Grid, Typography, Link } from '@mui/material';
import './App.css'
const FooterContainer = styled('footer')({
  backgroundColor: theme => theme.palette.primary.main,
  color: theme => theme.palette.common.white,
  paddingTop: theme => theme.spacing(3),
  paddingBottom: theme => theme.spacing(3),
});

const Footer = () => {
  return (
    <FooterContainer id='fgg' style={{"paddingLeft":"5vw"}}>
      <Container maxWidth="lg">
        <Grid container spacing={3}>
          <Grid item xs={12} sm={4}>
            <Typography variant="h6" fontWeight="bold" id='pol'>
              ABOUT US
            </Typography>
            <Typography variant="body1" id='fgg'>
              Learn about our mission, values, and history in providing life insurance solutions.
            </Typography>
          </Grid>
          <Grid item xs={12} sm={4} >
            <Typography variant="h6" fontWeight="bold" style={{"paddingLeft":"6vw"}} id='pol'>
              PRODUCTS
            </Typography>
            <ul style={{"paddingLeft":"6vw"}} id='fgg'>
              <li>
                <Link href="#" color="inherit" id='fgg'>
                  Term Life Insurance
                </Link>
              </li>
              <li>
                <Link href="#" color="inherit" id='fgg'>
                  Whole Life Insurance
                </Link>
              </li>
              <li>
                <Link href="#" color="inherit" id='fgg'>
                  Universal Life Insurance
                </Link>
              </li>
              <li>
                <Link href="#" color="inherit" id='fgg'>
                  Annuities
                </Link>
              </li>
            </ul>
          </Grid>
          <Grid item xs={12} sm={4}>
            <Typography variant="h6" fontWeight="bold" id='pol'>
              CONTACT US
            </Typography>
            <Typography variant="body1" id='fgg'>
              Reach out to our customer support team for inquiries, claims, and assistance.
            </Typography>
            <Typography variant="body1" id='fgg'>
              Email: <Link href="mailto:info@lifeInsurance.com" color="inherit">
                info@insurancecompany.com
              </Link>
            </Typography>
            <Typography variant="body1" id='fgg'>
              Phone: 123-456-7890
            </Typography>
          </Grid>
        </Grid>
        <Typography variant="body2" align="center" style={{ marginTop: '2rem' ,"paddingRight":"3.7vw"}} id='fg'>
          &copy; {new Date().getFullYear()} Insurance Company. All rights reserved.
        </Typography>
      </Container>
    </FooterContainer>
  );
};

export default Footer;
