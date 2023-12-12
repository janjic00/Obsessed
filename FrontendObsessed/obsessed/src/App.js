import React from 'react';
import './App.css';
import logo from './ObsessedSlike/Obsessedlogo123.png';
import kaizenImage from './ObsessedSlike/kaizenLogo1.png'; // Dodana putanja za Kaizen sliku
import BeliLogo from './ObsessedSlike/LogoBeli.jpeg';
import InstagramIcon from '@mui/icons-material/Instagram';
import ArrowDropDownIcon from '@mui/icons-material/ArrowDropDown';

const Insta ="https://www.instagram.com/obsessed.rs/";

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <div className="logo-container">
          <a href="/" className="home-link">
            Home
          </a>
          <img src={logo} alt="Logo" className="logo-image" />
        </div>

        <nav className="nav-container">
  <button className="shop-button">
    Shop 
    <ArrowDropDownIcon className="dropdown-icon" />
  </button>
  <div className="dropdown">
    <a href="#category1">OverSized</a>
    <a href="#category2">Socks</a>
    <a href="#category3">Stingers</a>
  </div>
</nav>

        <section className="first-section">
          <div className="overlay" />
          <button className="shop-now-button">Shop Now</button>
        </section>

        <section className="second-section">
          <div className="overlay" />
          <button className="shop-now-button">Shop Now</button>
        </section>

        <section className="third-section">
          <div className="overlay" />
          <button className="shop-now-button">Shop Now</button>
        </section>

        {/* Dodana sekcija za Kaizen sliku i opis */}
        <div className="kaizen-section">
          <img src={kaizenImage} alt="Kaizen Logo" className="kaizen-image" />
          <p className="kaizen-description">
    "Kaizen," originating from Japanese philosophy, embodies the concept of continuous improvement.
    It encourages the mindset that small, positive changes made consistently over time lead to significant advancements.
    In essence, it's about making incremental progress, fostering a culture of innovation, and striving for excellence in all endeavors.
  </p>
        </div>

<div className="bottom-menu">
  <div className="bottom-links">
    <a href={Insta} className="bottom-link instagram-link">
      {/* Dodatna div unutar linka za Instagram ikonu */}
      Follow us
      <div className="instagram-icon">
        <InstagramIcon />
      </div>
    
    </a>
    <p className="gmail">
      Contact us  on Obsessed@gmail.com
    </p>
  </div>
  <img src={BeliLogo} alt="Beli Logo" className="beli-logo" />
</div>
      </header>
    </div>
  );
}

export default App;