package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.MySQlConnection;
import model.Pedidos;

import java.io.File;
import java.sql.ResultSet;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;

public class ControllerCozinha {

    @FXML
    private ImageView IVLogo;

    @FXML
    private Button btnFecharCozinha;

    @FXML
    private ComboBox<Integer> cbNpedidos;

    @FXML
    private TableColumn<Pedidos, String> colNpedidos;

    @FXML
    private TableColumn<Pedidos, String> colOBS;

    @FXML
    private TableColumn<Pedidos, String> colProduto;

    @FXML
    private TableColumn<Pedidos, String> colQTD;

    @FXML
    private TableView<Pedidos> tblDetalhes;

    @FXML
    private TableView<Pedidos> tblNpedidos;

    @FXML
    private TextField tfNpedidos;

    private ObservableList<Pedidos> detalhesPedidos;

    private MySQlConnection connection;

    String str = null;

    public static final long TEMPO = (1000 * 1); // atualiza a cada 1 segundo

    public void initialize() throws Exception {
        //Colocar logotipo
        File file = new File("logo.png");
        Image image = new Image(file.toURI().toString());
        IVLogo.setImage(image);

        detalhesPedidos = FXCollections.observableArrayList();

        this.colProduto.setCellValueFactory(new PropertyValueFactory<Pedidos,String>("produto"));
        this.colQTD.setCellValueFactory(new PropertyValueFactory<Pedidos,String>("qtd"));
        this.colOBS.setCellValueFactory(new PropertyValueFactory<Pedidos,String>("obs"));

        str = this.tfNpedidos.getText();
        preencheComboBox();
        //preenchePedidos();
    }

    public void preenchePedidos() throws Exception {
        connection = new MySQlConnection();
        Timer timer = null;
        if (timer == null) {
            timer = new Timer();
            TimerTask tarefa = new TimerTask() {
                public void run() {
                    try {
                        preencheComboBox();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            timer.scheduleAtFixedRate(tarefa, TEMPO, TEMPO);
        }


    }

    public void preencheComboBox() throws Exception {
        connection = new MySQlConnection();
        ResultSet result = connection.numPedidos();
        this.cbNpedidos.getItems().clear();
        while(result.next())
        {
            int npedido = result.getInt(1);
            this.cbNpedidos.getItems().add(npedido);
        }
    }

    @FXML
    void fechar(ActionEvent event) {
        alert(Alert.AlertType.INFORMATION, "Fechou a cozinha!", "Obrigado!");
        System.exit(1);
    }

    @FXML
    void finalizarPedido(ActionEvent event) {

    }

    @FXML
    void verDetalhesPedido(ActionEvent event) {
        this.tblDetalhes.getItems().clear();

        try {
            int idpedido = this.cbNpedidos.getValue();
            connection = new MySQlConnection();
            ResultSet result = connection.detalhesPedidos(idpedido);
                while(result.next()) {
                    String produto = result.getString(1);
                    int qtd = result.getInt(2);
                    String obs = result.getString(3);

                    Pedidos p = new Pedidos(produto,qtd,obs,idpedido);
                    this.detalhesPedidos.add(p);
                }

            this.tfNpedidos.setText(str + idpedido);


            }catch (Exception e)
            {
                alert(Alert.AlertType.WARNING,"Numero de pedido nao selecionado!","Por favor, selecione um numero do pedido desejado!");
            }

             this.tblDetalhes.setItems(detalhesPedidos);
    }

    public void alert(Alert.AlertType type, String tit, String texto)
    {
        Alert alerta=new Alert(type);
        alerta.setTitle(tit);
        alerta.setHeaderText(null);
        alerta.setContentText(texto);
        alerta.showAndWait();
    }
}
