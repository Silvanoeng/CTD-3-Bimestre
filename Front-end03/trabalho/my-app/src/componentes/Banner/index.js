import React, { Component } from 'react'
import './style.css'
import 'bootstrap/dist/css/bootstrap.min.css';
import { Carousel } from 'react-bootstrap';
import slide01 from "../Img/imagem02.jpg"
import slide02 from "../Img/imagem03.jpg"
import slide03 from "../Img/imagem04.jpg"



export default class BannerCarousel extends Component {
    listaDeDados = [
        {
            id: 1,
            titulo: 'estagio 1',
            texto: 'Inicio da carreira como desenvolvedor foi em 24 de maio de 2021',
            slide: slide01,
            desFoto: 'Paisagem de uma lagoa'
        },
        {
            id: 2,
            titulo: 'estagio 2',
            texto: 'Inicio da carreira como desenvolvedor foi em 25 de maio de 2021',
            slide: slide02,
            desFoto: 'Paisagem de uma lagoa'
        },
        {
            id: 3,
            titulo: 'estagio 3',
            texto: 'Inicio da carreira como desenvolvedor foi em 26 de maio de 2021',
            slide: slide03,
            desFoto: 'Paisagem de uma lagoa'
        }
    ]
    render() {
        
        return (
            <Carousel>
                {
                    this.listaDeDados.map((parametro) => {
                        return (
                            <Carousel.Item key={parametro.id}>
                                <img src={parametro.slide} alt={parametro.desFoto} />
                                <Carousel.Caption>
                                    <h4>{parametro.titulo}</h4>
                                    <p>{parametro.texto}</p>
                                </Carousel.Caption>
                            </Carousel.Item>
                        )
                    })
                }

            </Carousel>
        )
    }
}

