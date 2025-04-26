package com.mateo.calculadoracompleta.extras;

public class Extras {

    public static long factorial(int n) {
        if (n < 0) {
            throw new ArithmeticException("No se puede calcular el factorial de un número negativo.");
        }
        long resultado = 1;
        for (int i = 1; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }

    public static boolean esPrimo(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void generarPrimosHasta(int n) {
        if (n < 2) {
            System.out.println("No hay números primos en ese rango.");
            return;
        }
        System.out.println("Números primos hasta " + n + ":");
        for (int i = 2; i <= n; i++) {
            if (esPrimo(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    // Conversor de temperatura
    public static double celsiusAFahrenheit(double celsius) {
        return celsius * 9 / 5 + 32;
    }

    public static double celsiusAKelvin(double celsius) {
        return celsius + 273.15;
    }

    public static double fahrenheitACelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static double kelvinACelsius(double kelvin) {
        return kelvin - 273.15;
    }

    // Conversor de Longitud
    public static double metrosAKilometros(double metros) {
        return metros / 1000;
    }

    public static double kilometrosAMetros(double kilometros) {
        return kilometros * 1000;
    }

    public static double metrosACentimetros(double metros) {
        return metros * 100;
    }

    public static double centimetrosAMetros(double centimetros) {
        return centimetros / 100;
    }

    // Conversor de Peso
    public static double kilogramosAGramos(double kilos) {
        return kilos * 1000;
    }

    public static double gramosAKilogramos(double gramos) {
        return gramos / 1000;
    }

    public static double kilogramosALibras(double kilos) {
        return kilos * 2.20462;
    }

    public static double librasAKilogramos(double libras) {
        return libras / 2.20462;
    }

    // Conversor de Tiempo
    public static double horasAMinutos(double horas) {
        return horas * 60;
    }

    public static double minutosAHoras(double minutos) {
        return minutos / 60;
    }

    public static double minutosASegundos(double minutos) {
        return minutos * 60;
    }

    public static double segundosAMinutos(double segundos) {
        return segundos / 60;
    }

}
