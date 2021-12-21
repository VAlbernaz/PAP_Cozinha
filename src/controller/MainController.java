package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class MainController {

    @FXML
    private ImageView IVLogo;

    @FXML
    private ComboBox cbUser;

    @FXML
    private TextField tfNomeUtilizador;

    @FXML
    private PasswordField pfPassword;

    @FXML
    private Button btnEntrar;

    @FXML
    private Button btnFechar;

    public void initialize()
    {
        //Colocar logotipo
        File file = new File("logo.png");
        Image image = new Image(file.toURI().toString());
        IVLogo.setImage(image);

        this.cbUser.getItems().addAll("Admin","Funcionario");
    }
    @FXML
    void login(ActionEvent event) {
        //Mudar password e ve de acordo com a bd
        if(this.cbUser.getValue().equals("Admin") &&this.pfPassword.getText().equals("Admin123"))
        {
            //Stage stage1 = (Stage) this.btnEntrar.getScene().getWindow();
            // stage1.close();
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/AdminView.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setTitle("GESRES 1.0");
                //stage.resizableProperty().setValue(Boolean.FALSE);

                //fecha vista de login ao entrar
                Stage stage1 = (Stage) this.btnEntrar.getScene().getWindow();
                stage1.close();

                stage.initModality(Modality.WINDOW_MODAL);
                stage.setScene(scene);
                stage.show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(this.cbUser.getValue().equals("Funcionario") &&this.pfPassword.getText().equals("123"))
        {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/FuncViewMesas.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setTitle("GESRES 1.0");
                stage.resizableProperty().setValue(Boolean.FALSE);

                //fecha vista de login ao entrar
                Stage stage1 = (Stage) this.btnEntrar.getScene().getWindow();
                stage1.close();

                stage.initModality(Modality.WINDOW_MODAL);
                stage.setScene(scene);
                stage.show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            alert(Alert.AlertType.ERROR,"Dados incorretos!","Nome de Utilizador ou Palavra-pass Incorreteos!");
        }

    }

    @FXML
    void fechar(ActionEvent event) {
        Stage stage = (Stage) this.btnFechar.getScene().getWindow();
        stage.close();


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
