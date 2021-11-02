import './style.css'

const BannerNovo = ({dia, foto, pronome1, pronome2, nome}) => {
    const Redirecionar = () =>{
       return window.open('https://br-playground.digitalhouse.com/login');
    }

    return (
        <>
            <p>Bom dia {nome}, desejamos que {pronome1} {dia} seja {pronome2}.</p>
            <img src={foto} alt='Foto do banner da pagina'/>
            <button onClick={Redirecionar}>Iniciar os estudos de {dia}</button>
        </>
    )

}

export default BannerNovo;