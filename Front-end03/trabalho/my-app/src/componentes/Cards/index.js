import React, { Component } from 'react'
import { Card, Button, CardGroup, Stack, Row, Col, Container } from 'react-bootstrap';
import './style.css'
import 'bootstrap/dist/css/bootstrap.min.css';
import img01 from "../../Img/site01.png"
import img02 from "../../Img/site02.png"
import img03 from "../../Img/site03.png"
import img04 from "../../Img/site04.png"




export default class CardsProjetos extends Component {
    lista = [
        {
            id: 1,
            titulo: 'Venha Colonizar Marte',
            descricao: 'Site de um formulario para registro de futuros colonizadores de Marte.',
            atividade: 'Atividade individual na disciplina de Front End I',
            data: 'Finalizado em 22/06/2021',
            img: img01,
            desFoto: 'Imagem do site Venha Colonizar Marte',
            urlGitHub: 'https://github.com/Silvanoeng/desafiosFrontEnd',
            urlGitPage: 'https://silvanoeng.github.io/desafiosFrontEnd/'
        },
        {
            id: 2,
            titulo: 'J² Rhapsody',
            descricao: 'Site de uma curadoria/loja de música.',
            atividade: 'Atividade em grupo na disciplina de Front End I.',
            data: 'Finalizado em 19/07/2021',
            img: img02,
            desFoto: 'Imagem do site J² Rhapsody',
            urlGitHub: 'https://github.com/Silvanoeng/empresaFrontEnd',
            urlGitPage: 'https://silvanoeng.github.io/empresaFrontEnd/'

        },
        {
            id: 3,
            titulo: 'Felinos',
            descricao: 'Site sobre felinos, onde são apresentados alguns dados dos seguintes animais: Tigre, Leão, Leopardo, Pantera Negra, Jaguar e Guerpado.',
            atividade: 'Atividade individual na disciplina de Front End II.',
            data: 'Finalizado em 24/08/2021',
            img: img03,
            desFoto: 'Imagem do site Felinos',
            urlGitHub: 'https://github.com/Silvanoeng/FrontEnd2/tree/master/Aula06',
            urlGitPage: 'https://silvanoeng.github.io/FrontEnd2/Aula06/index.html'
        },
        {
            id: 4,
            titulo: 'Cadastro de produtos',
            descricao: 'Site para cadastramento de produtos, com validaçãos dos campos de input.',
            atividade: 'Atividade em grupo na disciplina de Front End II.',
            data: 'Finalizado em 13/09/2021',
            img: img04,
            desFoto: 'Imagem do site para Cadastro de produtos',
            urlGitHub: 'https://github.com/Silvanoeng/checkpoint-1-front-end-II',
            urlGitPage: 'https://silvanoeng.github.io/checkpoint-1-front-end-II/'
        }
    ]
    render() {
        return (
            <div className='grupoCards'>
                <CardGroup className='pt-4 pb-4 containerCard' id='projetos'>
                    {
                        this.lista.map((parametro) => {
                            return (
                                <Card border="light" className='uniCard m-5' style={{ width: "18rem" }}    key={parametro.id} >
                                    <Card.Img variant="top" src={parametro.img} alt= {parametro.desFoto} thumbnail/>
                                    <Card.Body>
                                        <Card.Title className='text-center'>{parametro.titulo}</Card.Title>
                                        <Card.Text >
                                            <p>{parametro.descricao}</p>
                                            <p>{parametro.atividade}</p>
                                            <p>{parametro.data}</p>
                                        </Card.Text>
                                    </Card.Body>
                                        <Container>
                                            <Stack gap={2} variant="bottom" className='col-md-5 mx-auto  pb-3'>
                                                <Button href={parametro.urlGitHub} variant="secondary" >GitHub</Button> {' '}
                                                <Button href={parametro.urlGitPage}  variant="outline-secondary" >Site</Button>
                                            </Stack>
                                        </Container>
                                </Card>
                            )
                        })
                    }
                </CardGroup> 
            </div>  
        )
    }
}

