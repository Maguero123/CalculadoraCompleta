package com.mateo.calculadoracompleta.gui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ExtrasGUI {

    public void mostrar() {
        Stage stage = new Stage();
        stage.setTitle("Extras");

        Label titulo = new Label("Elegí una función:");
        titulo.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        ComboBox<String> combo = new ComboBox<>();
        combo.getItems().addAll(
                "Factorial",
                "Es primo",
                "Generar primos hasta N",
                "Conversor de temperatura (Celsius a Fahrenheit)"
        );

        TextField input = new TextField();
        input.setPromptText("Ingresá un número o valor");

        Button calcular = new Button("Calcular");
        calcular.setStyle("-fx-font-size: 14px;");

        Label resultado = new Label();
        resultado.setStyle("-fx-font-size: 14px; -fx-text-fill: blue;");

        Button volver = new Button("Volver al Menú Principal");
        volver.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 14px;");
        volver.setOnAction(e -> stage.close());

        calcular.setOnAction(e -> {
            try {
                String opcion = combo.getValue();
                int n = Integer.parseInt(input.getText());
                String res;

                switch (opcion) {
                    case "Factorial":
                        res = String.valueOf(factorial(n));
                        resultado.setText("Factorial de " + n + " es: " + res);
                        break;
                    case "Es primo":
                        res = (n > 1 && esPrimo(n)) ? "Sí es primo" : "No es primo";
                        resultado.setText("Resultado: " + res);
                        break;
                    case "Generar primos hasta N":
                        res = generarPrimosHasta(n);
                        resultado.setText("Primos hasta " + n + ": " + res);
                        break;
                    case "Conversor de temperatura (Celsius a Fahrenheit)":
                        res = n + " °C = " + celsiusAFahrenheit(n) + " °F";
                        resultado.setText("Resultado: " + res);
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
        layout.getChildren().addAll(titulo, combo, input, calcular, resultado, volver);

        Scene scene = new Scene(layout, 400, 350);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    private long factorial(int n) {
        if (n < 0) throw new ArithmeticException("No existe factorial de negativos.");
        long res = 1;
        for (int i = 1; i <= n; i++) res *= i;
        return res;
    }

    private boolean esPrimo(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) if (n % i == 0) return false;
        return true;
    }

    private String generarPrimosHasta(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            if (esPrimo(i)) sb.append(i).append(" ");
        }
        return sb.toString();
    }

    private double celsiusAFahrenheit(double celsius) {
        return celsius * 9 / 5 + 32;
    }
}
