import React, { Component } from 'react'
import './style.css'
import 'bootstrap/dist/css/bootstrap.min.css';
import { Carousel } from 'react-bootstrap';
import slide03 from "../../Img/imagem03.jpg"
import slide02 from "../../Img/imagem02.jpg"
import slide01 from "../../Img/imagem04.jpg"



export default class BannerCarousel extends Component {
    listaDeDados = [
        {
            id: 1,
            titulo: 'Minhas origens...',
            texto: 'Sou natural de Mostardas/RS, filho do seu Helio (mestre de obras) e dona Percilia (costureira), irmão da Vania (funcionária páblica).',
            slide: slide01,
            desFoto: 'Paisagem de uma lagoa'
        },
        {
            id: 2,
            titulo: 'Novos rumos...',
            texto: 'Em 2010 fui para Rio Grande/RS, onde cursei Engenharia Civil na Universidade Federal do Rio Grande, me formando no ano de 2015.',
            slide: slide02,
            desFoto: 'Paisagem de uma lagoa'
        },
        {
            id: 3,
            titulo: 'O regresso...',
            texto: 'Em 2016 voltei para Mostardas, onde atuei como Engenheiro Civil até maio de 2021, deste periodo 3 anos foram como Engenheiro da Prefeitura.',
            slide: slide03,
            desFoto: 'Paisagem de uma lagoa'
        }
    ]
    render() {
        
        return (
            <Carousel className='carousel'>
                {
                    this.listaDeDados.map((parametro) => {
                        return (
                            <Carousel.Item key={parametro.id} id='inicio'>
                                <img className='img-fluid d-block' src={parametro.slide} alt={parametro.desFoto} />
                                <Carousel.Caption className='d-none d-md-block'>
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

