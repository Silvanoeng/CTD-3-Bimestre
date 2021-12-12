import { BrowserRouter, Routes, Route } form 'react-router-dom';
import Home from '..pages/Home';

const RouteList = () => {
    return (
        <BrowserRouter>
            <Routes>
                <Route path="/home" element={<Home />}/>
                <Route path="/sobre" element={<h2>Sobre mim</h2>}/>
                <Route path="*" element={<h2>404 Esta pagina não existe.</h2>}/>
            </Routes>
        </BrowserRouter>
    )
}