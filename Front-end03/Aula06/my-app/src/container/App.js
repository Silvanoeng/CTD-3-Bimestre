import ClassComponent from '../componentes/ClassComponent';
import FunctionComponent from '../componentes/FunctionComponent';
import '../styles/App.css';

function App() {
  return (
    <div className="App">
       <h3>Convidados:</h3>
     <ClassComponent />
     <h3>Tarefa: </h3>
     <FunctionComponent />

    </div>
  );
}

export default App;
