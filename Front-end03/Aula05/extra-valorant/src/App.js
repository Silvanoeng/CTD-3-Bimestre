import Banner from './components/Banner';
import Footer from './components/Footer';
import Galeria from './components/Galeria';
import Header from './components/Header';
import Valorant from './components/Valorant';

import './App.css';

function App() {
  return (
    <div>
      <Header />
      <main>
        <Banner />
        <Valorant />
        <Galeria />
      </main>
      <Footer />
    </div>
  );
}

export default App;
