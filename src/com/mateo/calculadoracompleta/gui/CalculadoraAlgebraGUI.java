package com.mateo.calculadoracompleta.gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CalculadoraAlgebraGUI extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Álgebra - Ecuaciones de segundo grado");

        Label titulo = new Label("Ingresá la ecuación cuadrática (ej: 2x² - 5x + 3 = 0):");
        titulo.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        TextField inputEcuacion = new TextField();
        Button resolverBtn = new Button("Resolver");
        resolverBtn.setStyle("-fx-font-size: 14px;");

        Label resultado = new Label();
        resultado.setStyle("-fx-font-size: 14px; -fx-text-fill: blue;");

        Button volver = new Button("Volver al Menú Principal");
        volver.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 14px;");
        volver.setOnAction(e -> stage.close());

        resolverBtn.setOnAction(e -> {
            String ecuacion = inputEcuacion.getText();
            try {
                double[] coef = parsearEcuacion(ecuacion);
                resultado.setText(resolverEcuacionSegundoGrado(coef[0], coef[1], coef[2]));
            } catch (Exception ex) {
                resultado.setText("Error: " + ex.getMessage());
            }
        });

        VBox layout = new VBox(12);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(titulo, inputEcuacion, resolverBtn, resultado, volver);

        Scene scene = new Scene(layout, 400, 300);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    public void mostrar() {
        Stage stage = new Stage();
        start(stage);
    }

    private double[] parsearEcuacion(String ecuacion) throws Exception {
        ecuacion = ecuacion.replace(" ", "").replace("=0", "");
        double a = 0, b = 0, c = 0;

        String regexA = "([+-]?\\d*)x²";
        String regexB = "([+-]?\\d*)x(?!²)";
        String regexC = "([+-]?\\d+)(?!x)";

        var patternA = java.util.regex.Pattern.compile(regexA);
        var patternB = java.util.regex.Pattern.compile(regexB);
        var patternC = java.util.regex.Pattern.compile(regexC);

        var matcherA = patternA.matcher(ecuacion);
        var matcherB = patternB.matcher(ecuacion);
        var matcherC = patternC.matcher(ecuacion);

        if (matcherA.find()) {
            String coef = matcherA.group(1);
            a = coef.isEmpty() || coef.equals("+") ? 1 : coef.equals("-") ? -1 : Double.parseDouble(coef);
        }
        if (matcherB.find()) {
            String coef = matcherB.group(1);
            b = coef.isEmpty() || coef.equals("+") ? 1 : coef.equals("-") ? -1 : Double.parseDouble(coef);
        }
        if (matcherC.find()) {
            c = Double.parseDouble(matcherC.group(1));
        }
        if (a == 0) throw new Exception("El coeficiente a no puede ser 0.");
        return new double[]{a, b, c};
    }

    private String resolverEcuacionSegundoGrado(double a, double b, double c) {
        double discriminante = b * b - 4 * a * c;
        if (discriminante > 0) {
            double x1 = (-b + Math.sqrt(discriminante)) / (2 * a);
            double x2 = (-b - Math.sqrt(discriminante)) / (2 * a);
            return "Dos soluciones reales: x1 = " + x1 + ", x2 = " + x2;
        } else if (discriminante == 0) {
            double x = -b / (2 * a);
            return "Una solución real: x = " + x;
        } else {
            return "No hay soluciones reales (raíces imaginarias).";
        }
    }
}
