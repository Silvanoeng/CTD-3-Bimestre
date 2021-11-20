
import React from "react"
import BannerCarousel from '../componentes/Banner/index';
import CardsProjetos from '../componentes/Cards/index';
import Footer from '../componentes/Footer/index';
import Header from '../componentes/Header/index';
import 'bootstrap/dist/css/bootstrap.min.css';


function App() {
  const nomeEmpresa = 'Silvano A. P.';
  const nome = 'Lucas';
  var data = new Date();
  const diaDaSemana = ["domingo", "segunda-feira", "terça-feira", "quarta-feira", "quinta-feira", "sexta-feira", "sábado"]
  const dia = diaDaSemana[data.getDay()];


  return (
    <>
      <div>
        <Header nomeEmpresa={nomeEmpresa} />
      </div>
      
      <BannerCarousel/>

      <CardsProjetos/>
      
      
      <div className="Footer">
        <Footer>Todos direitos reservado a {nomeEmpresa}. O uso desse material é exclusivo de {nome}.</Footer>
      </div>
    </>
  );
}

export default App;
