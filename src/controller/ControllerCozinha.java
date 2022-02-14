package controller;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;

public class ControllerCozinha {

    @FXML
    private ImageView IVLogo;

    public void initialize()
    {
        //Colocar logotipo
        File file = new File("logo.png");
        Image image = new Image(file.toURI().toString());
        IVLogo.setImage(image);
    }
}
