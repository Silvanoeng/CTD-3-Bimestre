/* eslint-disable jsx-a11y/anchor-is-valid */
import ClassComponent from '../componentes/ClassComponent';
import FunctionComponent from '../componentes/FunctionComponent';
import '../styles/App.scss';

function App() {
  

  return (
    <>
    <nav className="navbar navbar-expand-sm navbar-dark bg-dark" aria-label="Third navbar example">
    <div className="container-fluid">
      <a className="navbar-brand" href="#">Festa da Xuxa</a>
      <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarsExample03" aria-controls="navbarsExample03" aria-expanded="false" aria-label="Toggle navigation">
        <span className="navbar-toggler-icon"></span>
      </button>

      <div className="collapse navbar-collapse" id="navbarsExample03">
        <ul className="navbar-nav me-auto mb-2 mb-sm-0">
          <li className="nav-item">
            <a className="nav-link" href="#">Home</a>
          </li>
          <li className="nav-item">
            <a className="nav-link" href="#">Balas</a>
          </li>
          <li className="nav-item">
            <a className="nav-link" href="#">Sucos</a>
          </li>
          <li className="nav-item dropdown">
            <a className="nav-link dropdown-toggle" href="#" id="dropdown03" data-bs-toggle="dropdown" aria-expanded="false">Datas</a>
            <ul className="dropdown-menu" aria-labelledby="dropdown03">
              <li><a className="dropdown-item" href="#">21/12/2021</a></li>
              <li><a className="dropdown-item" href="#">25/01/2022</a></li>
              <li><a className="dropdown-item" href="#">29/08/2022</a></li>
            </ul>
          </li>
        </ul>
        <form>
          <input className="form-control" type="text" placeholder="Search" aria-label="Search"/>
        </form>
      </div>
    </div>
  </nav>
    <br/>
    <div className="App">
       <h3 className="d-flex justify-content-center">Convidados:</h3>
     <ClassComponent />
     <br/>
     <h3 className="d-flex justify-content-center">Tarefa: </h3>
     <FunctionComponent />

    </div>
    </>
  );
}

export default App;
