import React from 'react';
import logo from './logo.svg';
import ShortenUrl from "./components/ShortenUrl";
import './App.css';

function App() {
  return (
    <div className="App">
      <header >
        <img src={logo} className="App-logo" alt="logo" />
      </header>
        <ShortenUrl />
    </div>
  );
}

export default App;
