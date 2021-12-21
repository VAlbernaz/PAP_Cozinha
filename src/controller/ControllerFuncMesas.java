package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;


import java.io.IOException;

import static javafx.scene.paint.Color.RED;

public class ControllerFuncMesas {

    @FXML
    private ImageView IVLogo;

    @FXML
    private Button btnMCinco;

    @FXML
    private Button btnMDez;

    @FXML
    private Button btnMDois;

    @FXML
    private Button btnMNove;

    @FXML
    private Button btnMOito;

    @FXML
    private Button btnMQuatro;

    @FXML
    private Button btnMSeis;

    @FXML
    private Button btnMSete;

    @FXML
    private Button btnMTres;

    @FXML
    private Button btnMUm;

    @FXML
    private Button btnBalcao;


    @FXML
    void mesaUM(ActionEvent event) {
        int numMesa = 1;
        // true= verde   false = vermelho
        boolean corButao=true;

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/FuncViewDetMesas.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("GESRES 1.0");

            stage.resizableProperty().setValue(Boolean.FALSE);

            ControllerFuncDetMesas controller = loader.getController();
            controller.getNmMesa(numMesa);


            stage.initModality(Modality.WINDOW_MODAL);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void mesaDois(ActionEvent event) {
        int numMesa = 2;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/FuncViewDetMesas.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("GESRES 1.0");
            stage.resizableProperty().setValue(Boolean.FALSE);

            ControllerFuncDetMesas controller = loader.getController();
            controller.getNmMesa(numMesa);

            stage.initModality(Modality.WINDOW_MODAL);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void mesaTres(ActionEvent event) {
        int numMesa = 3;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/FuncViewDetMesas.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("GESRES 1.0");
            stage.resizableProperty().setValue(Boolean.FALSE);

            ControllerFuncDetMesas controller = loader.getController();
            controller.getNmMesa(numMesa);

            stage.initModality(Modality.WINDOW_MODAL);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void mesaQuatro(ActionEvent event) {
        int numMesa = 4;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/FuncViewDetMesas.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("GESRES 1.0");
            stage.resizableProperty().setValue(Boolean.FALSE);

            ControllerFuncDetMesas controller = loader.getController();
            controller.getNmMesa(numMesa);

            stage.initModality(Modality.WINDOW_MODAL);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void mesaCinco(ActionEvent event) {
        int numMesa = 5;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/FuncViewDetMesas.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("GESRES 1.0");
            stage.resizableProperty().setValue(Boolean.FALSE);

            ControllerFuncDetMesas controller = loader.getController();
            controller.getNmMesa(numMesa);

            stage.initModality(Modality.WINDOW_MODAL);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void mesaSeis(ActionEvent event) {
        int numMesa = 6;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/FuncViewDetMesas.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("GESRES 1.0");
            stage.resizableProperty().setValue(Boolean.FALSE);

            ControllerFuncDetMesas controller = loader.getController();
            controller.getNmMesa(numMesa);

            stage.initModality(Modality.WINDOW_MODAL);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void mesaSete(ActionEvent event) {
        int numMesa = 7;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/FuncViewDetMesas.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("GESRES 1.0");
            stage.resizableProperty().setValue(Boolean.FALSE);

            ControllerFuncDetMesas controller = loader.getController();
            controller.getNmMesa(numMesa);

            stage.initModality(Modality.WINDOW_MODAL);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void mesaOito(ActionEvent event) {
        int numMesa = 8;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/FuncViewDetMesas.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("GESRES 1.0");
            stage.resizableProperty().setValue(Boolean.FALSE);

            ControllerFuncDetMesas controller = loader.getController();
            controller.getNmMesa(numMesa);

            stage.initModality(Modality.WINDOW_MODAL);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void mesaNove(ActionEvent event) {
        int numMesa = 9;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/FuncViewDetMesas.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("GESRES 1.0");
            stage.resizableProperty().setValue(Boolean.FALSE);

            ControllerFuncDetMesas controller = loader.getController();
            controller.getNmMesa(numMesa);

            stage.initModality(Modality.WINDOW_MODAL);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void mesaDez(ActionEvent event) {
        int numMesa = 10;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/FuncViewDetMesas.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("GESRES 1.0");
            stage.resizableProperty().setValue(Boolean.FALSE);

            ControllerFuncDetMesas controller = loader.getController();
            controller.getNmMesa(numMesa);

            stage.initModality(Modality.WINDOW_MODAL);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void balcao(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/FuncViewPedidos.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root,1400,900);
            Stage stage = new Stage();
            stage.setTitle("GESRES 1.0");
            //stage.setMaximized(Boolean.TRUE);
            stage.resizableProperty().setValue(Boolean.FALSE);

            //fecha vista de login ao entrar
            //Stage stage1 = (Stage) this.btnEntrar.getScene().getWindow();
            //stage1.close();

            stage.initModality(Modality.WINDOW_MODAL);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
