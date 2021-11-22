import React from "react"
import Nave from '../componentes/Navbar/index';
import BannerCarousel from '../componentes/Banner/index';
import CardsProjetos from '../componentes/Cards/index';
import Curriculo from '../componentes/Curriculo/index';
import Footer from '../componentes/Footer/index';
import './App.scss';

function App() {
  return (
    <>

      <Nave/>
      
      <BannerCarousel/>

      <CardsProjetos/>
      
      <Curriculo/>

      <Footer/>
      
    </>
  );
}

export default App;