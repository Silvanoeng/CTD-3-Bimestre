import { PerguntaDoDia , BannerNovo } from '../componentes/Banner/index';

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
    <div className="App">
      <PerguntaDoDia nome={nome} pronome1={pronome1} pronome2={pronome2} dia={dia}  />
      <BannerNovo foto={fotoBanner} dia={dia} />
    </div>
  );
}

export default App;
