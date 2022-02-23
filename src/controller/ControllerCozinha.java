package controller;

import javafx.application.Platform;
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

    @FXML
    private Button btnAbrirPedido;

    private ObservableList<Pedidos> detalhesPedidos;
    private ObservableList<Pedidos> pedidosConfeção;

    private MySQlConnection connection;

    private Pedidos linhaPedido;

    String str = null;
    int idpedidotf =0;
    int idpedido = 0;

    public static final long TEMPO = (1000 * 5); // atualiza a cada 5 segundo

    public void initialize() throws Exception {
        //Colocar logotipo
        File file = new File("logo.png");
        Image image = new Image(file.toURI().toString());
        IVLogo.setImage(image);

        detalhesPedidos = FXCollections.observableArrayList();
        pedidosConfeção = FXCollections.observableArrayList();

        this.colProduto.setCellValueFactory(new PropertyValueFactory<Pedidos,String>("produto"));
        this.colQTD.setCellValueFactory(new PropertyValueFactory<Pedidos,String>("qtd"));
        this.colOBS.setCellValueFactory(new PropertyValueFactory<Pedidos,String>("obs"));

        this.colNpedidos.setCellValueFactory(new PropertyValueFactory<Pedidos,String>("idpedido"));

        str = this.tfNpedidos.getText();
        this.tblDetalhes.getItems().clear();
        this.tfNpedidos.setText(str);

        preencheComboBox();
        preecheTabelaPedidos();
        preenchePedidos();
    }

    public void preenchePedidos() throws Exception {
        connection = new MySQlConnection();
        Timer timer = null;
        if (timer == null) {
            timer = new Timer();
            TimerTask tarefa = new TimerTask() {
                public void run() {
                    Platform.runLater(() -> {
                        try {
                            preencheComboBox();
                        } catch (Exception e) {

                        }
                    });
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
        linhaPedido = this.tblNpedidos.getSelectionModel().getSelectedItem();
        if(linhaPedido != null) {
            int idpedidofinalizar = linhaPedido.getIdpedido();
            connection = new MySQlConnection();
            if (connection.alteraEstado(idpedidofinalizar, "Fechado")) {
                alert(Alert.AlertType.INFORMATION, "Sucesso!", "Pedido finalizado com sucesso.");

                this.tblNpedidos.getItems().clear();
                preecheTabelaPedidos();

                if(idpedidotf == idpedidofinalizar)
                {
                    this.tblDetalhes.getItems().clear();
                    this.tfNpedidos.setText(str);
                }
            } else {
                alert(Alert.AlertType.WARNING, "Atenção!", "Aconteceu um erro.");
            }
        }else
        {
            alert(Alert.AlertType.ERROR,"ERRO!","Selecione um pedido.");
        }
    }

    @FXML
    void verDetalhesPedido(ActionEvent event) {
        linhaPedido = this.tblNpedidos.getSelectionModel().getSelectedItem();
        if(linhaPedido != null) {
            this.tblDetalhes.getItems().clear();
            int idpedidoDetalhes = linhaPedido.getIdpedido();
            idpedidotf = idpedidoDetalhes;
            ResultSet result = connection.detalhesPedidos(idpedidoDetalhes);
            try {
                while (result.next()) {
                    String produto = result.getString(1);
                    int qtd = result.getInt(2);
                    String obs = result.getString(3);
                    Pedidos p = new Pedidos(produto, qtd, obs, idpedidoDetalhes);
                    this.detalhesPedidos.add(p);
                }
            } catch (Exception e) {
                alert(Alert.AlertType.WARNING, "Numero de pedido nao selecionado!", "Por favor, selecione um numero do pedido desejado!");
            }
            this.tblDetalhes.setItems(detalhesPedidos);
            this.tfNpedidos.setText(str + idpedidotf);
            this.tblNpedidos.getSelectionModel().clearSelection();
        }else {
            alert(Alert.AlertType.WARNING, "Numero de pedido nao selecionado!", "Por favor, selecione um numero do pedido desejado!");
        }
    }

    public void preecheTabelaPedidos()
    {
        connection = new MySQlConnection();

        ResultSet result = connection.numPedidosEmConfeção();
        int idpedido = 0;
        try {
            while (result.next())
            {
                idpedido = result.getInt(1);
                Pedidos p = new Pedidos(idpedido);
                pedidosConfeção.add(p);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        this.tblNpedidos.setItems(pedidosConfeção);

    }

    @FXML
    void abrirPedido(ActionEvent event) {
            try {
                idpedido = this.cbNpedidos.getValue();
                if(idpedido != 0) {
                    idpedidotf = idpedido;
                    connection = new MySQlConnection();

                    connection.alteraEstado(idpedido, "Em confeção");
                    this.tblNpedidos.getItems().clear();
                    preecheTabelaPedidos();
                    preencheComboBox();
                }else
                {
                    alert(Alert.AlertType.WARNING, "Numero de pedido nao selecionado!", "Por favor, selecione um numero do pedido desejado!");

                }
            } catch (Exception e) {
                alert(Alert.AlertType.WARNING, "Numero de pedido nao selecionado!", "Por favor, selecione um numero do pedido desejado!");
            }
            if(idpedido!=0) {
                ResultSet result = connection.detalhesPedidos(idpedido);
                this.tblDetalhes.getItems().clear();
                try {
                    while (result.next()) {
                        String produto = result.getString(1);
                        int qtd = result.getInt(2);
                        String obs = result.getString(3);
                        Pedidos p = new Pedidos(produto, qtd, obs, idpedido);
                        this.detalhesPedidos.add(p);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.tblDetalhes.setItems(detalhesPedidos);
                this.tfNpedidos.setText(str + idpedido);
            }
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
