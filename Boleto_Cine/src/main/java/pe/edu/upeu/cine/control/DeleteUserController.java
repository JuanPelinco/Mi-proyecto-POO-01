package pe.edu.upeu.cine.control;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pe.edu.upeu.cine.repositorio.UsuarioRepositorio;

public class DeleteUserController {

    @FXML private TextField txtDeleteUser;

    private final UsuarioRepositorio usuarioRepo = new UsuarioRepositorio();

    @FXML
    public void eliminarUsuario() {
        String user = txtDeleteUser.getText();

        if (user.isEmpty()) {
            new Alert(Alert.AlertType.WARNING, "Ingrese un usuario").show();
            return;
        }

        if (usuarioRepo.eliminarUsuario(user)) {
            new Alert(Alert.AlertType.INFORMATION, "Usuario eliminado correctamente").show();
            ((Stage) txtDeleteUser.getScene().getWindow()).close();
        } else {
            new Alert(Alert.AlertType.ERROR, "No existe el usuario").show();
        }
    }
}
