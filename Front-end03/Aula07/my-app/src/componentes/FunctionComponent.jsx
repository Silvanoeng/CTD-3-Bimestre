import React from 'react'
import { Fragment } from 'react';
 
const functionComponent = () => {
    const listaDeConvidados = [
        {
          id: 0,
          firstName: 'Silvano',
          comida: 'batata-frita'
        },
        {
          id: 10,
          firstName: 'Marina',
          comida: 'cerveja'
        },
        {
          id: 70,
          firstName: 'Isadora',
          comida: 'bolo de chocolate'
        }
      ]
       return (
           <>
           {
            listaDeConvidados.map ((convidado) => {
             return (
                 <Fragment key={convidado.id}>
                 <li className="d-flex justify-content-center">{convidado.firstName} trará {convidado.comida}.</li>
                 </Fragment>
                    )
                })
            }

           </>
   )
}
export default functionComponent