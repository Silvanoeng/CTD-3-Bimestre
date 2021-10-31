
import React from 'react'
import './App.css';
import homem from './componentes/img/homem-feliz-dinheiro.jpg'



function App() {
  return (
    <div className="App">
      <header className="App-header">
        {/* eslint-disable-next-line jsx-a11y/alt-text */}
        <img src={homem }/>
      </header>
    </div>
  );
}

export default App;
