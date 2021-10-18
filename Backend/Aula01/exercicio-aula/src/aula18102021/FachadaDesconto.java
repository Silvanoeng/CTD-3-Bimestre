package aula18102021;

public class FachadaDesconto implements IFachadaDesconto{

    private ApiCartao apiCartao;
    private ApiProduto apiProduto;
    private ApiQuantidade apiQuantidade;


    public FachadaDesconto() {
        this.apiCartao = new ApiCartao();
        this.apiProduto = new ApiProduto();
        this.apiQuantidade = new ApiQuantidade();
    }



    @Override
    public int desconto(Cartao cartao, Produto produto, int quantidade) {
        int desconto = 0;
        desconto+= apiQuantidade.desconto(quantidade);
        desconto+= apiCartao.desconto(cartao);
        desconto+= apiProduto.desconto(produto);
        return desconto;
    }
}
