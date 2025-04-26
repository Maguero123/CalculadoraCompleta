package com.mateo.calculadoracompleta.gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainGUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("🧮 Súper Calculadora Completa de Mateo 🧮");

        Label titulo = new Label("Elegí una opción:");
        titulo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        Button btnBasicas = new Button("Operaciones Básicas");
        Button btnAlgebra = new Button("Álgebra");
        Button btnEstadisticas = new Button("Estadísticas");
        Button btnExtras = new Button("Extras");
        Button btnSalir = new Button("Salir");

        // Estilo de botones
        String estiloBotones = "-fx-font-size: 16px; -fx-background-color: #2196F3; -fx-text-fill: white;";
        btnBasicas.setStyle(estiloBotones);
        btnAlgebra.setStyle(estiloBotones);
        btnEstadisticas.setStyle(estiloBotones);
        btnExtras.setStyle(estiloBotones);
        btnSalir.setStyle("-fx-font-size: 16px; -fx-background-color: #f44336; -fx-text-fill: white;");

        // Acciones de los botones
        btnBasicas.setOnAction(e -> new OperacionesBasicasGUI().mostrar());
        btnAlgebra.setOnAction(e -> new CalculadoraAlgebraGUI().mostrar());
        btnEstadisticas.setOnAction(e -> new EstadisticasGUI().mostrar());
        btnExtras.setOnAction(e -> new ExtrasGUI().mostrar());
        btnSalir.setOnAction(e -> primaryStage.close());

        VBox layout = new VBox(15);
        layout.setPadding(new Insets(25));
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(titulo, btnBasicas, btnAlgebra, btnEstadisticas, btnExtras, btnSalir);

        Scene scene = new Scene(layout, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
