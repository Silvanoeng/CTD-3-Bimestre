import './style.css'

const BannerNovo = ({dia, pronome1, pronome2, nome}) => {
    const Redirecionar = () =>{
       return window.open('https://br-playground.digitalhouse.com/login');
    }

    return (
        <>
            <p className='saudacao'>Bom dia {nome}, desejamos que {pronome1} {dia} seja {pronome2}.</p>
            <button className='btn' onClick={Redirecionar}>Iniciar os estudos de {dia}</button>
        </>
    )

}

export default BannerNovo;