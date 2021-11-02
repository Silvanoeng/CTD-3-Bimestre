import './style.css';

const Header = ({children}) => {


    return(
        <div>
            <p>{children}</p>
        </div>
    );
}

export default Header;