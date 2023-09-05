import React from 'react';
import './App.css';

function AboutUs() {
  return (
    <div className="about-us" id='but' style={{"textAlign":"center","marginTop":"12vh"}}>
      <section className="hero">
        <div className="hero-content">
          <h1>ABOUT LIFE INSURANCE</h1>
          <p>Your Trusted Partner for Life Protection</p>
        </div>
      </section>
      <section className="mission">
        <div className="mission-content" style={{"marginTop":"8vh"}}>
          <h2>OUR MISSION</h2>
          <p>
            At LifeSure Insurance, our mission is to provide peace of mind and financial security to individuals and families through our comprehensive life insurance products.
          </p>
        </div>
      </section>
      <section className="values">
        <div className="values-content" style={{"marginTop":"8vh"}}>
          <h2>OUR REMARKABKE POLICIES</h2>
          <div style={{"marginRight":"2.5vw","marginTop":"4vh"}}>
            <ul>Term Life Insurance</ul>
            <ul>Whole Life Insurance</ul>
            <ul>Universal Life Insurance</ul>
            <ul>Guaranteed Issue Life Insurance</ul>
            <ul>Joint Life Insurance</ul>
         </div>
        </div>
      </section>
      <section className="team">
        <div className="team-content" style={{"marginTop":"8vh"}}>
          <h2>OUR PILLARS (TEAM) 🏛️</h2>
          <p>
            Our dedicated team of professionals is committed to serving you with the utmost care and expertise. We are here to guide you towards a secure financial future.
          </p>
        </div>
      </section>
    </div>
  );
}

export default AboutUs;
