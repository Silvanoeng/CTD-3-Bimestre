import './style.css';
import React, { useState} from 'react';
import { Navbar, Nav, Container } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';

const Nave = () => {
    
    const [navbar, setNavbar] = useState(false);

    const navBackground = () => {
        if(window.scrollY >= 60) {
           setNavbar(true) 
        } else {
            setNavbar(false)
        }
    };
    
    
    window.addEventListener('scroll', navBackground);

    return (
        <Navbar className= {navbar ? "navbar-shrink-light navbar navbar-light fixed-top navbar-expand-lg navbar-dark ps-3" : "navbarCor navbar navbar-light fixed-top navbar-expand-lg navbar-dark ps-3"} bg="light" expand="lg">
            <Container>
                <Navbar.Brand className={navbar ? 'navLogo navcor': 'navLogo navcor2'} href="#inicio">Silvano A. P.</Navbar.Brand>
                <Navbar.Toggle aria-controls="basic-navbar-nav" />
                <Navbar.Collapse id="basic-navbar-nav">
                    <Nav className='navbar-nav ms-auto my-2 my-lg-0'>
                        <Nav.Link className={navbar ? 'navcor': 'navcor2'} href="#inicio">Inicio</Nav.Link>
                        <Nav.Link className={navbar ? 'navcor': 'navcor2'} href="#projetos">Projetos</Nav.Link>
                        <Nav.Link className={navbar ? 'navcor': 'navcor2'} href="#curriculo">Curriculo</Nav.Link>
                        <Nav.Link className={navbar ? 'navcor': 'navcor2'} href="#contatos">Contatos</Nav.Link> 
                    </Nav>
                </Navbar.Collapse>
            </Container>
        </Navbar>
    )
}
export default Nave;