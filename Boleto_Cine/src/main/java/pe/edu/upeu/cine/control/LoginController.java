package pe.edu.upeu.cine.control;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pe.edu.upeu.cine.repositorio.UsuarioRepositorio;

public class LoginController {

    @FXML private TextField txtUser;
    @FXML private PasswordField txtPass;

    private final UsuarioRepositorio usuarioRepo = new UsuarioRepositorio();

    @FXML
    public void loginAction() {
        String user = txtUser.getText();
        String pass = txtPass.getText();

        if (user.isEmpty() || pass.isEmpty()) {
            new Alert(Alert.AlertType.WARNING, "Complete todos los campos").show();
            return;
        }

        if (usuarioRepo.validarUsuario(user, pass)) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Principal.fxml"));

                Stage stage = new Stage();
                Scene scene = new Scene(loader.load());

                scene.getStylesheets().add(
                        getClass().getResource("/css/darkpro.css").toExternalForm()
                );

                stage.setScene(scene);
                stage.setTitle("Sistema Cine - Pelinco");
                stage.show();

                ((Stage) txtUser.getScene().getWindow()).close();

            } catch (Exception e) {
                e.printStackTrace();
                new Alert(Alert.AlertType.ERROR, "Error cargando la pantalla principal").show();
            }

        } else {
            new Alert(Alert.AlertType.ERROR, "Usuario o contraseña incorrectos").show();
        }
    }

    @FXML
    public void openRegisterWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Register.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(loader.load());
            scene.getStylesheets().add(getClass().getResource("/css/darkpro.css").toExternalForm());
            stage.setTitle("Registrar Usuario");
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void openDeleteWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/DeleteUser.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(loader.load());
            scene.getStylesheets().add(getClass().getResource("/css/darkpro.css").toExternalForm());
            stage.setTitle("Eliminar Usuario");
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
