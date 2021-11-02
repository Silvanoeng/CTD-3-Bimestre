import BannerNovo from '../componentes/Banner/index';
import Footer from '../componentes/Footer/index';
import Header from '../componentes/Header/index';
import '../styles/App.css';

function App() {
  const nome = 'Lucas';
  const fotoBanner = 'https://cdn.pixabay.com/photo/2016/05/13/14/16/solar-rays-1390059_960_720.jpg'
  var data = new Date();
  const diaDaSemana = ["domingo", "segunda-feira", "terça-feira", "quarta-feira", "quinta-feira", "sexta-feira", "sábado"]
  const dia = diaDaSemana[data.getDay()];

  var pronome1;
  var pronome2;
  if(data.getDay()===0 || data.getDay()===6){
    pronome1 = 'seu';
    pronome2 = 'produtivo';
  } else {
    pronome1 = 'sua';
    pronome2 = 'produtiva';
  }

  return (
    <>
    <div className="Header">
      <Header>DH School</Header>

    </div>
    <div className="Banner">
      
      <BannerNovo nome={nome} pronome1={pronome1} pronome2={pronome2} foto={fotoBanner} dia={dia} />

    </div>
    <div className="Footer">
      <Footer>Todos direitos reservado a DH. O uso desse material é exclusivo de {nome}.</Footer>
    </div>
    </>
  );
}

export default App;
