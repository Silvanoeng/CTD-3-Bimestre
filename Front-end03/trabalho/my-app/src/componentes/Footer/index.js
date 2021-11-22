import React, { Component } from 'react'
import './style.scss'
import '../../container/App.scss';
import icone01 from "../../Img/iconmonstr-github-1.svg"
import icone02 from "../../Img/iconmonstr-linkedin-3.svg"
import icone03 from "../../Img/iconmonstr-twitter-3.svg"

export default class Footer extends Component {
    lista = [
        {
            id: 1,
            icone: icone01,
            descIcone: 'Icone do github',
            url: 'https://github.com/Silvanoeng'
        },
        {
            id: 2,
            icone: icone02,
            descIcone: 'Icone do linkedin',
            url: 'https://www.linkedin.com/in/silvano-araujo-pereira-0616083b/'
        },
        {
            id: 3,
            icone: icone03,
            descIcone: 'Icone do instagram',
            url: 'https://twitter.com/Silvanoeng'
        }
    ]
    render() {
        return (
            <footer className='grupoIcone'>
                <h2 className='meusCont ms-3 pt-3'>Meus contatos:</h2>
                    <div className='containerFooter' id='contatos'>
                        
                        {
                            this.lista.map((parametro) => {
                                return (
                                    <div className='m-5'>
                                        <a  href={parametro.url}><img className='uniIcone' src={parametro.icone} alt={parametro.descIcone}/></a>
                                    </div>    
                                )
                            })
                        }
                    </div>
                <p className='textoDesen'>Desenvolvido por Silvano Araujo Pereira - 2021</p>
            </footer> 
        )
    }
}