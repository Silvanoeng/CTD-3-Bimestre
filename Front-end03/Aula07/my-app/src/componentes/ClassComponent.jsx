import React, { Component } from 'react'
import { Fragment } from 'react';
export default class ClassComponent extends Component {
   render() {
    const listaDeConvidados = [
        {
          id: 0,
          firstName: 'Silvano'
        },
        {
          id: 10,
          firstName: 'Marina'
        },
        {
          id: 70,
          firstName: 'Isadora'
        }
      ]
       return (
           <>
           {
            listaDeConvidados.map ((convidado) => {
             return (
                 <Fragment key= {convidado.id}>
                 <li className="d-flex justify-content-center">{convidado.firstName} está convidado para festa.</li>
                 </Fragment>
                    )
                })
            }

           </>
       )
   }
}
