package com.mateo.calculadoracompleta.algebra;

public class Algebra {

    public static double resolverEcuacionPrimerGrado(double a, double b) {
        if (a == 0) {
            throw new ArithmeticException("No es una ecuación válida (a no puede ser cero).");
        }
        return -b / a;
    }

    public static String resolverEcuacionSegundoGrado(double a, double b, double c) {
        if (a == 0) {
            throw new ArithmeticException("No es una ecuación cuadrática (a no puede ser cero).");
        }

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
