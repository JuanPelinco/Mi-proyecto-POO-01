package pe.edu.upeu.cine.control;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pe.edu.upeu.cine.repositorio.UsuarioRepositorio;

public class RegisterController {

    @FXML private TextField txtNewUser;
    @FXML private PasswordField txtNewPass;

    private final UsuarioRepositorio usuarioRepo = new UsuarioRepositorio();

    @FXML
    public void registrarUsuario() {
        String user = txtNewUser.getText();
        String pass = txtNewPass.getText();

        if (user.isEmpty() || pass.isEmpty()) {
            new Alert(Alert.AlertType.WARNING, "Complete todos los campos").show();
            return;
        }

        if (usuarioRepo.registrarUsuario(user, pass)) {
            new Alert(Alert.AlertType.INFORMATION, "Usuario registrado con éxito").show();
            ((Stage) txtNewUser.getScene().getWindow()).close();
        } else {
            new Alert(Alert.AlertType.ERROR, "Error: usuario ya existe").show();
        }
    }
}
