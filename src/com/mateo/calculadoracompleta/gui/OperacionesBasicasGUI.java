package com.mateo.calculadoracompleta.gui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class OperacionesBasicasGUI {

    public void mostrar() {
        Stage stage = new Stage();
        stage.setTitle("Operaciones Básicas");

        Label lblOperacion = new Label("Elegí la operación:");
        lblOperacion.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        ComboBox<String> combo = new ComboBox<>();
        combo.getItems().addAll("Sumar", "Restar", "Multiplicar", "Dividir", "Potencia", "Raíz Cuadrada");

        TextField num1 = new TextField();
        num1.setPromptText("Primer número");

        TextField num2 = new TextField();
        num2.setPromptText("Segundo número (o vacío para raíz)");

        Button calcular = new Button("Calcular");
        calcular.setStyle("-fx-font-size: 14px;");

        Label resultado = new Label();
        resultado.setStyle("-fx-font-size: 14px; -fx-text-fill: blue;");

        Button volver = new Button("Volver al Menú Principal");
        volver.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 14px;");
        volver.setOnAction(e -> stage.close());

        calcular.setOnAction(e -> {
            try {
                double a = Double.parseDouble(num1.getText());
                double b = num2.getText().isEmpty() ? 0 : Double.parseDouble(num2.getText());
                String operacion = combo.getValue();
                double res;

                switch (operacion) {
                    case "Sumar":
                        res = a + b;
                        break;
                    case "Restar":
                        res = a - b;
                        break;
                    case "Multiplicar":
                        res = a * b;
                        break;
                    case "Dividir":
                        if (b == 0) throw new ArithmeticException("No se puede dividir por cero");
                        res = a / b;
                        break;
                    case "Potencia":
                        res = Math.pow(a, b);
                        break;
                    case "Raíz Cuadrada":
                        res = Math.sqrt(a);
                        break;
                    default:
                        throw new Exception("Elegí una operación.");
                }
                resultado.setText("Resultado: " + res);
            } catch (Exception ex) {
                resultado.setText("Error: " + ex.getMessage());
            }
        });

        VBox layout = new VBox(12); // Más espacio entre los elementos
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(lblOperacion, combo, num1, num2, calcular, resultado, volver);

        Scene scene = new Scene(layout, 350, 400);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
}
