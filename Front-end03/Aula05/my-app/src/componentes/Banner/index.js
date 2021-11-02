function PerguntaDoDia (props) {

    return (
        <div>
            <p>Bom dia {props.nome}, desejamos que {props.pronome1} {props.dia} seja {props.pronome2}.</p>
        </div>
    )
}

function BannerNovo (props){
    return (
        <div>
            <img src={props.foto} alt='Foto do banner da pagina'/>
            <button>Iniciar os estudos de {props.dia}</button>
        </div>
    )

}

export { PerguntaDoDia , BannerNovo };