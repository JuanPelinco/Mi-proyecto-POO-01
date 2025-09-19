package pe.edu.upeu;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VentaBoleto extends Application {

    // Lista de reservas (modelo de datos)
    private final ObservableList<Reserva> reservas = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) {
        Label titulo = new Label("Reserva tu vuelo ✈️");
        titulo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        // ComboBox para destinos
        ComboBox<String> destinos = new ComboBox<>();
        destinos.getItems().addAll(
                "Perú", "París", "Nueva York",
                "Tokio", "Buenos Aires", "Ciudad de México"
        );
        destinos.setPromptText("Selecciona un destino");

        // DatePicker para fecha
        DatePicker fechaVuelo = new DatePicker();
        fechaVuelo.setPromptText("Selecciona la fecha de tu viaje");

        // Tabla de reservas
        TableView<Reserva> tabla = new TableView<>();
        tabla.setItems(reservas);

        TableColumn<Reserva, String> colDestino = new TableColumn<>("Destino");
        colDestino.setCellValueFactory(new PropertyValueFactory<>("destino"));

        TableColumn<Reserva, String> colFecha = new TableColumn<>("Fecha");
        colFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));

        tabla.getColumns().addAll(colDestino, colFecha);
        tabla.setPrefHeight(200);

        // Botón de confirmación
        Button confirmar = new Button("Confirmar reserva");
        confirmar.setOnAction(e -> {
            String destino = destinos.getValue();
            String fecha = (fechaVuelo.getValue() != null) ? fechaVuelo.getValue().toString() : null;

            if (destino != null && fecha != null) {
                reservas.add(new Reserva(destino, fecha));
                destinos.setValue(null); // limpiar selección
                fechaVuelo.setValue(null);
            } else {
                Alert alerta = new Alert(Alert.AlertType.WARNING, "Selecciona un destino y una fecha, por favor.");
                alerta.showAndWait();
            }
        });

        VBox root = new VBox(15, titulo, destinos, fechaVuelo, confirmar, tabla);
        root.setStyle("-fx-padding: 20; -fx-alignment: center; -fx-background-color: #f0f8ff;");

        Scene scene = new Scene(root, 500, 400);
        primaryStage.setTitle("Selección de Destino de Viaje");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Clase modelo simple para la tabla
    public static class Reserva {
        private final String destino;
        private final String fecha;

        public Reserva(String destino, String fecha) {
            this.destino = destino;
            this.fecha = fecha;
        }

        public String getDestino() {
            return destino;
        }

        public String getFecha() {
            return fecha;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

