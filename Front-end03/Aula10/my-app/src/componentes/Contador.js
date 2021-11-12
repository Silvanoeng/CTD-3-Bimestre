import React, { Component } from 'react'
export default class Contador extends Component {
  constructor() {
    super();
    this.state = {
      

    };
  }
  removeProduto = (idProduto) => {
    const segundos = this.state.listaMercado.filter(({ id }) => {
      for (i=0; i<60; i++){
      }
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
                    
                    </div>
                 )
               })
             }
           </div>
       )
   }
}
