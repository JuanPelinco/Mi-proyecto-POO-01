package pe.edu.upeu.sistemaalumnos.control;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import pe.edu.upeu.sistemaalumnos.modelo.*;
import pe.edu.upeu.sistemaalumnos.servicio.VentaServicio;

import java.sql.Date;

public class VentaFxControl {

    @FXML private TextField txtCliente;
    @FXML private ComboBox<Destino> cmbDestino;
    @FXML private ComboBox<Horario> cmbHorario;
    @FXML private TextField txtPrecio;
    @FXML private TextField txtFecha;

    @FXML private TableView<Venta> tablaVentas;
    @FXML private TableColumn<Venta, Integer> colId;
    @FXML private TableColumn<Venta, String> colCliente;
    @FXML private TableColumn<Venta, String> colDestino;
    @FXML private TableColumn<Venta, Double> colPrecio;
    @FXML private TableColumn<Venta, Date> colFecha;

    private final VentaServicio servicio = new VentaServicio();
    private ObservableList<Venta> listaVentas;

    @FXML
    public void initialize() {

        cmbDestino.setItems(FXCollections.observableArrayList(servicio.listarDestinos()));
        cmbHorario.setItems(FXCollections.observableArrayList(servicio.listarHorarios()));


        colId.setCellValueFactory(c -> new javafx.beans.property.SimpleObjectProperty<>(c.getValue().getId()));
        colCliente.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getCliente()));
        colDestino.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getDestino().getNombre()));
        colPrecio.setCellValueFactory(c -> new javafx.beans.property.SimpleObjectProperty<>(c.getValue().getPrecio()));
        colFecha.setCellValueFactory(c -> new javafx.beans.property.SimpleObjectProperty<>(c.getValue().getFecha()));

        refrescarTabla();
    }

    @FXML
    public void agregarVenta() {
        try {
            String cliente = txtCliente.getText();
            Destino destino = cmbDestino.getSelectionModel().getSelectedItem();
            Horario horario = cmbHorario.getSelectionModel().getSelectedItem();
            double precio = Double.parseDouble(txtPrecio.getText());
            Date fecha = Date.valueOf(txtFecha.getText());

            if (cliente.isEmpty() || destino == null || horario == null) {
                mostrarAlerta("Completa todos los campos");
                return;
            }

            Venta v = new Venta();
            v.setCliente(cliente);
            v.setDestino(destino);
            v.setHorario(horario);
            v.setPrecio(precio);
            v.setFecha(fecha);

            servicio.guardarVenta(v);
            mostrarAlerta("Venta registrada correctamente");
            refrescarTabla();
        } catch (Exception e) {
            mostrarAlerta("Error al agregar venta: " + e.getMessage());
        }
    }

    @FXML
    public void actualizarVenta() {
        Venta seleccionada = tablaVentas.getSelectionModel().getSelectedItem();
        if (seleccionada == null) {
            mostrarAlerta("Selecciona una venta para actualizar");
            return;
        }

        try {
            String cliente = txtCliente.getText();
            Destino destino = cmbDestino.getSelectionModel().getSelectedItem();
            Horario horario = cmbHorario.getSelectionModel().getSelectedItem();
            double precio = Double.parseDouble(txtPrecio.getText());
            Date fecha = Date.valueOf(txtFecha.getText());

            if (cliente.isEmpty() || destino == null || horario == null) {
                mostrarAlerta("Completa todos los campos");
                return;
            }

            seleccionada.setCliente(cliente);
            seleccionada.setDestino(destino);
            seleccionada.setHorario(horario);
            seleccionada.setPrecio(precio);
            seleccionada.setFecha(fecha);

            servicio.actualizarVenta(seleccionada);
            mostrarAlerta("Venta actualizada correctamente");
            refrescarTabla();
        } catch (Exception e) {
            mostrarAlerta("Error al actualizar venta: " + e.getMessage());
        }
    }

    @FXML
    public void eliminarVenta() {
        Venta seleccionada = tablaVentas.getSelectionModel().getSelectedItem();
        if (seleccionada != null) {
            servicio.eliminarVenta(seleccionada.getId());
            mostrarAlerta("Venta eliminada correctamente");
            refrescarTabla();
        } else {
            mostrarAlerta("Selecciona una venta para eliminar");
        }
    }

    @FXML
    public void volverMenu() {
        // Código para volver a la ventana principal
    }

    private void refrescarTabla() {
        listaVentas = FXCollections.observableArrayList(servicio.listarVentas());
        tablaVentas.setItems(listaVentas);
    }

    private void mostrarAlerta(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Aviso");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}


