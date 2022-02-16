package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.swing.*;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

public class ControllerCozinha {

    @FXML
    private ImageView IVLogo;

    @FXML
    private Button btnFecharCozinha;



    public static final long TEMPO = (1000 * 1); // atualiza a cada 1 segundo

    public void initialize() throws Exception {
        //Colocar logotipo
        File file = new File("logo.png");
        Image image = new Image(file.toURI().toString());
        IVLogo.setImage(image);

        preenchePedidos();
    }

    public void preenchePedidos() throws Exception {
        Timer timer = null;
        if (timer == null) {
            timer = new Timer();
            TimerTask tarefa = new TimerTask() {
                public void run() {
                    try {
                        System.out.println("Deu certo!!");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            timer.scheduleAtFixedRate(tarefa, TEMPO, TEMPO);
        }


    }

    @FXML
    void fechar(ActionEvent event) {
        alert(Alert.AlertType.INFORMATION, "Fechou a cozinha!", "Obrigado!");
        System.exit(1);
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
