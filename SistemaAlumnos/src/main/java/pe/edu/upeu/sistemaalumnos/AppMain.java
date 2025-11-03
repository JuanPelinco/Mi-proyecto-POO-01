package pe.edu.upeu.sistemaalumnos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMain extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // Carga del FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/AlumnoVista.fxml"));
        Scene scene = new Scene(loader.load());

        scene.getStylesheets().add(getClass().getResource("/css/estilo.css").toExternalForm());


        stage.setTitle("🎓 Sistema de Gestión de Alumnos");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

