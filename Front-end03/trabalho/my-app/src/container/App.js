import './style.css';
import React from "react"
import BannerCarousel from '../componentes/Banner/index';
import CardsProjetos from '../componentes/Cards/index';
import Footer from '../componentes/Footer/index';
import Nave from '../componentes/Navbar/index';
import Curriculo from '../componentes/Curriculo/index';
import 'bootstrap/dist/css/bootstrap.min.css';


function App() {
  
  return (
    <>
      
      <Nave/>
      
      
      <BannerCarousel/>

      <CardsProjetos/>
      
      <Curriculo/>

      
      {/* <Footer/> */}
      
    </>
  );
}

export default App;
