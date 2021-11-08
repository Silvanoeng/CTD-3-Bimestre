/* eslint-disable jsx-a11y/anchor-is-valid */
import RemoveItem from '../componentes/RemoveItem';
import '../styles/App.scss';

function App() {
  

  return (
    <>
    <nav className="navbar navbar-expand-sm navbar-dark bg-dark" aria-label="Third navbar example">
    <div className="container-fluid">
      <a className="navbar-brand" href="#">Mercado</a>
      <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarsExample03" aria-controls="navbarsExample03" aria-expanded="false" aria-label="Toggle navigation">
        <span className="navbar-toggler-icon"></span>
      </button>

      <div className="collapse navbar-collapse" id="navbarsExample03">
        <ul className="navbar-nav me-auto mb-2 mb-sm-0">
          <li className="nav-item">
            <a className="nav-link" href="#">Home</a>
          </li>
          <li className="nav-item">
            <a className="nav-link" href="#">Pedidos</a>
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
       <h3 className="d-flex justify-content-center">Lista:</h3>
     <RemoveItem/>
    

    </div>
    </>
  );
}

export default App;
