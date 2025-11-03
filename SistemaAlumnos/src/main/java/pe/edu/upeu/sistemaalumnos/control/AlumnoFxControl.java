package pe.edu.upeu.sistemaalumnos.control;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import pe.edu.upeu.sistemaalumnos.modelo.Alumno;
import pe.edu.upeu.sistemaalumnos.servicio.AlumnoServicio;

public class AlumnoFxControl {

    @FXML private TableView<Alumno> tablaAlumnos;
    @FXML private TableColumn<Alumno, Integer> colId;
    @FXML private TableColumn<Alumno, String> colNombre;
    @FXML private TableColumn<Alumno, String> colApellido;
    @FXML private TableColumn<Alumno, Integer> colEdad;
    @FXML private TableColumn<Alumno, String> colCorreo;

    @FXML private TextField txtNombre;
    @FXML private TextField txtApellido;
    @FXML private TextField txtEdad;
    @FXML private TextField txtCorreo;

    private final AlumnoServicio servicio = new AlumnoServicio();
    private ObservableList<Alumno> data;

    @FXML
    public void initialize() {
        colId.setCellValueFactory(c ->
                new javafx.beans.property.SimpleObjectProperty<>(c.getValue().getId()));
        colNombre.setCellValueFactory(c ->
                new javafx.beans.property.SimpleStringProperty(c.getValue().getNombre()));
        colApellido.setCellValueFactory(c ->
                new javafx.beans.property.SimpleStringProperty(c.getValue().getApellido()));
        colEdad.setCellValueFactory(c ->
                new javafx.beans.property.SimpleObjectProperty<>(c.getValue().getEdad()));
        colCorreo.setCellValueFactory(c ->
                new javafx.beans.property.SimpleStringProperty(c.getValue().getCorreo()));

        listarAlumnos();
    }

    @FXML
    public void listarAlumnos() {
        data = FXCollections.observableArrayList(servicio.listarAlumnos());
        tablaAlumnos.setItems(data);
    }

    @FXML
    public void agregarAlumno() {
        Alumno a = new Alumno(
                0,
                txtNombre.getText(),
                txtApellido.getText(),
                Integer.parseInt(txtEdad.getText()),
                txtCorreo.getText()
        );
        servicio.agregarAlumno(a);
        listarAlumnos();
    }

    @FXML
    public void actualizarAlumno() {
        Alumno seleccionado = tablaAlumnos.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            mostrarAlerta("Selecciona un alumno primero");
            return;
        }
        Alumno a = new Alumno(
                seleccionado.getId(),
                txtNombre.getText(),
                txtApellido.getText(),
                Integer.parseInt(txtEdad.getText()),
                txtCorreo.getText()
        );
        servicio.actualizarAlumno(a);
        listarAlumnos();
    }

    @FXML
    public void eliminarAlumno() {
        Alumno seleccionado = tablaAlumnos.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            servicio.eliminarAlumno(seleccionado.getId());
            listarAlumnos();
        } else {
            mostrarAlerta("Selecciona un alumno para eliminar");
        }
    }

    @FXML
    public void irAVentas() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/VentaVista.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = (Stage) tablaAlumnos.getScene().getWindow();
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void mostrarAlerta(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Aviso");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
