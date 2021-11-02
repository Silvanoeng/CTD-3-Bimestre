import BannerNovo from '../componentes/Banner/index';
import Footer from '../componentes/Footer/index';
import Header from '../componentes/Header/index';

function App() {
  const nomeEmpresa='DH School';
  const nome = 'Lucas';
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
    <div>
      <Header nomeEmpresa={nomeEmpresa}/>

    </div>
    <div className="fotoBanner">
      
      <BannerNovo nome={nome} pronome1={pronome1} pronome2={pronome2} dia={dia} />

    </div>
    <div className="Footer">
      <Footer>Todos direitos reservado a {nomeEmpresa}. O uso desse material é exclusivo de {nome}.</Footer>
    </div>
    </>
  );
}

export default App;
