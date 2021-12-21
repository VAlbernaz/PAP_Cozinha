package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerFuncDetMesas {

    @FXML
    private ImageView IVLogo;

    @FXML
    private Button btnClearMesa;

    @FXML
    private Button btnEditPedido;

    @FXML
    private Button btnNovoPedido;

    @FXML
    private Button btnPagar;

    @FXML
    private Label lbMesa;

    private int numesa;

    public void initialize()
    {

    }

    void getNmMesa(int mesa){
        numesa=mesa;
        String str = lbMesa.getText();
        this.lbMesa.setText(str + String.valueOf(numesa));
    }


    @FXML
    void ClearMesa(ActionEvent event) {

    }

    @FXML
    void editPedido(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/FuncViewPedidos.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root,1400 , 900);
            Stage stage = new Stage();
            stage.setTitle("GESRES 1.0");
            //stage.setMaximized(Boolean.TRUE);
            stage.resizableProperty().setValue(Boolean.FALSE);

            stage.initModality(Modality.WINDOW_MODAL);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void novoPedido(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/FuncViewPedidos.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root,1400,900);
            Stage stage = new Stage();
            stage.setTitle("GESRES 1.0");
            //stage.setMaximized(Boolean.TRUE);
            stage.resizableProperty().setValue(Boolean.FALSE);

            stage.initModality(Modality.WINDOW_MODAL);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void pagamento(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/ContribuinteView.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("GESRES 1.0");
            stage.resizableProperty().setValue(Boolean.FALSE);

            stage.initModality(Modality.WINDOW_MODAL);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

