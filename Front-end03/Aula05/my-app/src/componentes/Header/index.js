import './style.css';

const Header = ({nomeEmpresa}) => {


    return(
        <header>
            <h1>{nomeEmpresa}</h1>
            <nav>
                <ul>
                    <li><a href="https://www.linkedin.com/feed/">Linkedin</a></li>
                    <li><a href="https://github.com/">GitHub</a></li>
                </ul>
            </nav>
        </header>
    );
}

export default Header;