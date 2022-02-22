package model;

public class Pedidos {
    private String produto;
    private int qtd;
    private String obs;
    private int idpedido;


    public Pedidos(int idpedido) {
        this.idpedido = idpedido;
    }

    public Pedidos(String produto, int qtd, String obs, int idpedido) {
        this.produto = produto;
        this.qtd = qtd;
        this.obs = obs;
        this.idpedido = idpedido;
    }

    public int getIdpedido() {
        return idpedido;
    }

    public void setIdpedido(int idpedido) {
        this.idpedido = idpedido;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }
}
