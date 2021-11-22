import './style.scss'
import '../../container/App.scss';
import disquete from '../../Img/disquete.png';
import curriculo from '../../PDF/SilvanoAraujo.pdf';

const Curriculo = () => {

    return (
        <>
            <div className="container text-center" id='curriculo'>
                <div className='m-5'>
                    <h2 class="mb-4">Meu Curriculo</h2>
                    <a className="btn btn-xl" href={curriculo}><img className='uniDisquete' src={disquete} alt='Imagem de um disquete'/></a>
                </div>
            </div>
            
        </>
    )
}

export default Curriculo;