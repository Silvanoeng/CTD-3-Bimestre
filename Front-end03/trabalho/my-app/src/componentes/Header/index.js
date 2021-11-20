import './style.css';
import { Navbar, Nav, Container } from 'react-bootstrap';
const Header = ({ nomeEmpresa }) => {


    return (
        <Navbar bg="light" expand="lg">
            <Container>
                <Navbar.Brand href="#home">{nomeEmpresa}</Navbar.Brand>
                <Navbar.Toggle aria-controls="basic-navbar-nav" />
                <Navbar.Collapse id="basic-navbar-nav">
                    <Nav className="navbar-nav ms-auto my-2 my-lg-0">
                        <Nav.Link href="#inicio">Inicio</Nav.Link>
                        <Nav.Link href="#projetos">Projetos</Nav.Link>
                        <Nav.Link href="#tecnologias">Tecnologias</Nav.Link>
                        <Nav.Link href="#contatos">Contatos</Nav.Link>
                        
                    </Nav>
                </Navbar.Collapse>
            </Container>
        </Navbar>





        // <header>
        //     <h1>{nomeEmpresa}</h1>
        //     <nav>
        //         <ul>
        //             <li><a href="https://www.linkedin.com/feed/">Linkedin</a></li>
        //             <li><a href="https://github.com/">GitHub</a></li>
        //         </ul>
        //     </nav>
        // </header>
    );
}

export default Header;