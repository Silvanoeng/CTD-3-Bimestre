import React, { Component } from 'react'
export default class RemoveItem extends Component {
  constructor() {
    super();
    this.state = {
      listaMercado: [
        {
          id: 0,
          firstName: 'Pão',
          url: 'https://lh3.googleusercontent.com/proxy/Gc5YQlG_Pi054_mI54W-w0rJ2g1PuzOBW4RG05e9W3ostRWaFl_omDUlOoWV_xLVxVQOJEJwgR2sT9JxP2BCesZF3k3yRnNnY8JatvZxkeKFET65jguYL8vYcko'
        },
        {
          id: 10,
          firstName: 'Queijo',
          url: 'https://static.clubeextra.com.br/img/uploads/1/647/598647.png'
        },
        {
          id: 70,
          firstName: 'Requeijão',
          url: 'https://www.coopsantaclara.com.br/upload/product/1564489555_requeijao_tradicional_180g.png'
        }
      ]

    };
  }
  removeProduto = (idProduto) => {
    const listaNova = this.state.listaMercado.filter(({ id }) => {
      return id !== idProduto
    });
    this.setState({
      listaMercado: listaNova
    });
  }
  
  render() {
       return (
           <div>
             {
               this.state.listaMercado.map(({id, firstName, url}) => {
                 return (
                   <div  key={id} onClick={() => this.removeProduto(id)}>
                     <br/>
                     <div className="d-flex justify-content-center">
                     <img src={url} height="100px" ></img>
                     </div>
                     
                     <h3 className="d-flex justify-content-center" >{firstName}</h3>
                    </div>
                 )
               })
             }
           </div>
       )
   }
}
