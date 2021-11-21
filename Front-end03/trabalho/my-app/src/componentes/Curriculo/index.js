import curriculo from '../../PDF/SilvanoAraujo.pdf';
import 'bootstrap/dist/css/bootstrap.min.css';
import disquete from '../../Img/disquete.png';

const Curriculo = () => {

    return (
        <>
            <div className="container text-center" id='curriculo'>
                <h2 class="mb-4">Meu Curriculo</h2>
                <a className="btn btn-xl" href={curriculo}><img width='25%' src={disquete} alt='Imagem de um disquete'/></a>
            </div>
            
        </>
    )
}

export default Curriculo;