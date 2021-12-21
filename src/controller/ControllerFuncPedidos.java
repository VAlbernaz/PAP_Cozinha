package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import model.Pedidos;

public class ControllerFuncPedidos {

    @FXML
    private ImageView IVLogo;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnBebidasAlcool;

    @FXML
    private Button btnCafes;

    @FXML
    private Button btnCozinha;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnDoces;

    @FXML
    private Button btnEdit;

    @FXML
    private Button btnFinalizar;

    @FXML
    private Button btnNovoPedido;

    @FXML
    private Button btnSnacks;

    @FXML
    private Button btnSumos;

    @FXML
    private ComboBox<?> cbQTD;

    //tabela pedidos
    @FXML
    private TableColumn<?,?> colProduto;

    @FXML
    private TableColumn<?,?> colQTD;

    @FXML
    private TableColumn<?,?> colValor;

    @FXML
    private TableView<?> tblPedido;

    //tabela produtos
    @FXML
    private TableView<?> tblProdutos;

    @FXML
    private TableColumn<?, ?> colProdutos;

    @FXML
    private TableColumn<?, ?> colValorProduto;

    @FXML
    private TextField tfRetalho;

    public void initialize()
    {

    }
    @FXML
    void add(ActionEvent event) {
        String valor = this.tfRetalho.getText();
    }

    @FXML
    void editar(ActionEvent event) {

    }

    @FXML
    void eliminar(ActionEvent event) {

    }

    @FXML
    void finalizar(ActionEvent event) {

    }

    @FXML
    void novoPedido(ActionEvent event) {

    }

    @FXML
    void preencheBebidasAlcool(ActionEvent event) {

    }

    @FXML
    void preencheCafes(ActionEvent event) {

    }

    @FXML
    void preencheCozinha(ActionEvent event) {

    }

    @FXML
    void preencheDoces(ActionEvent event) {

    }

    @FXML
    void preencheSnacks(ActionEvent event) {

    }

    @FXML
    void preencheSumos(ActionEvent event) {

    }

    @FXML
    void qtd(ActionEvent event) {

    }

}

