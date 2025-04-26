package com.mateo.calculadoracompleta.gui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class EstadisticasGUI {

    public void mostrar() {
        Stage stage = new Stage();
        stage.setTitle("Estadísticas");

        Label lbl = new Label("Ingresá los números separados por coma (ej: 4,5,6,7):");
        lbl.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        TextField input = new TextField();

        ComboBox<String> combo = new ComboBox<>();
        combo.getItems().addAll("Media", "Mediana", "Moda", "Varianza", "Desviación estándar", "Rango");

        Button calcular = new Button("Calcular");
        calcular.setStyle("-fx-font-size: 14px;");

        Label resultado = new Label();
        resultado.setStyle("-fx-font-size: 14px; -fx-text-fill: blue;");

        Button volver = new Button("Volver al Menú Principal");
        volver.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 14px;");
        volver.setOnAction(e -> stage.close());

        calcular.setOnAction(e -> {
            try {
                double[] numeros = Arrays.stream(input.getText().split(","))
                        .mapToDouble(Double::parseDouble).toArray();
                String operacion = combo.getValue();
                double res;

                switch (operacion) {
                    case "Media":
                        res = Arrays.stream(numeros).average().orElse(0);
                        resultado.setText("Media: " + res);
                        break;
                    case "Mediana":
                        Arrays.sort(numeros);
                        res = (numeros.length % 2 == 0)
                                ? (numeros[numeros.length / 2 - 1] + numeros[numeros.length / 2]) / 2
                                : numeros[numeros.length / 2];
                        resultado.setText("Mediana: " + res);
                        break;
                    case "Moda":
                        res = calcularModa(numeros);
                        resultado.setText("Moda: " + res);
                        break;
                    case "Varianza":
                        double media = Arrays.stream(numeros).average().orElse(0);
                        res = Arrays.stream(numeros).map(n -> Math.pow(n - media, 2)).sum() / numeros.length;
                        resultado.setText("Varianza: " + res);
                        break;
                    case "Desviación estándar":
                        double varianza = Arrays.stream(numeros).map(n -> Math.pow(n - Arrays.stream(numeros).average().orElse(0), 2)).sum() / numeros.length;
                        res = Math.sqrt(varianza);
                        resultado.setText("Desviación estándar: " + res);
                        break;
                    case "Rango":
                        res = Arrays.stream(numeros).max().getAsDouble() - Arrays.stream(numeros).min().getAsDouble();
                        resultado.setText("Rango: " + res);
                        break;
                    default:
                        resultado.setText("Elegí una opción.");
                }
            } catch (Exception ex) {
                resultado.setText("Error: " + ex.getMessage());
            }
        });

        VBox layout = new VBox(12);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(lbl, input, combo, calcular, resultado, volver);

        Scene scene = new Scene(layout, 400, 350);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    private double calcularModa(double[] numeros) {
        Map<Double, Integer> frecuencia = new HashMap<>();
        for (double n : numeros) {
            frecuencia.put(n, frecuencia.getOrDefault(n, 0) + 1);
        }
        return frecuencia.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(0.0);
    }
}
