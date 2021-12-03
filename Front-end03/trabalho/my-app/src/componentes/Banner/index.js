import React, { Component } from 'react'
import { Carousel } from 'react-bootstrap';
import './style.scss'
import '../../container/App.scss';
import slide01 from "../../Img/foto01.jpg"
import slide02 from "../../Img/foto02.jpg"
import slide03 from "../../Img/foto05.jpg"
import slide04 from "../../Img/foto04.jpg"

export default class BannerCarousel extends Component {
    listaDeDados = [
        {
            id: 1,
            titulo: 'Minhas origens...',
            texto: 'Sou natural de Mostardas/RS, filho do seu Helio (mestre de obras) e dona Percilia (costureira), irmão da Vania (funcionária pública).',
            slide: slide01,
            desFoto: 'Paisagem de um farol'
        },
        {
            id: 2,
            titulo: 'Novos rumos...',
            texto: 'Em 2010 fui para Rio Grande/RS, onde cursei Engenharia Civil na Universidade Federal do Rio Grande, me formando no ano de 2015.',
            slide: slide02,
            desFoto: 'Paisagem de um por do sol na lagoa, chegando na cidade de Rio Grande.'
        },
        {
            id: 3,
            titulo: 'O regresso...',
            texto: 'Em 2016 voltei para Mostardas, onde atuei como Engenheiro Civil até maio de 2021, neste mesmo periodo 3 anos foram como Engenheiro da Prefeitura.',
            slide: slide03,
            desFoto: 'Paisagem de um campo com sol e uma figueira.'
        },
        {
            id: 4,
            titulo: 'Novas perspectivas...',
            texto: 'Em maio de 2021 se inicia minha transição de carreira para a área de tecnologia, onde o ponto de partida foi o curso Certified Tech Developer na Digital House.',
            slide: slide04,
            desFoto: 'Paisagem de uma noite estrelada, com um homem segurando um espelho que reflete o céu.'
        }
    ]
    render() {
        
        return (
            <Carousel className='carousel' id='inicio'>
                {
                    this.listaDeDados.map((parametro) => {
                        return (
                            <Carousel.Item key={parametro.id} interval={1000}>
                                <img className='img-fluid d-block' src={parametro.slide} alt={parametro.desFoto} />
                                <Carousel.Caption className='textoCarousel d-none d-md-block'>
                                    <h3>{parametro.titulo}</h3>
                                    <p className='texBanner'>{parametro.texto}</p>
                                </Carousel.Caption>
                            </Carousel.Item>
                        )
                    })
                }

            </Carousel>
        )
    }
}