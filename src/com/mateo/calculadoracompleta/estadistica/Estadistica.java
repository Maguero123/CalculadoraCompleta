package com.mateo.calculadoracompleta.estadistica;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Estadistica {

    public static double calcularMedia(double[] numeros) {
        double suma = 0;
        for (double num : numeros) {
            suma += num;
        }
        return suma / numeros.length;
    }

    public static double calcularMediana(double[] numeros) {
        Arrays.sort(numeros);
        int n = numeros.length;
        if (n % 2 == 0) {
            return (numeros[n / 2 - 1] + numeros[n / 2]) / 2.0;
        } else {
            return numeros[n / 2];
        }
    }

    public static double calcularModa(double[] numeros) {
        Map<Double, Integer> frecuencia = new HashMap<>();
        for (double num : numeros) {
            frecuencia.put(num, frecuencia.getOrDefault(num, 0) + 1);
        }

        int maxFrecuencia = 0;
        double moda = numeros[0];

        for (Map.Entry<Double, Integer> entry : frecuencia.entrySet()) {
            if (entry.getValue() > maxFrecuencia) {
                maxFrecuencia = entry.getValue();
                moda = entry.getKey();
            }
        }
        return moda;
    }

    public static double calcularVarianza(double[] numeros) {
        double media = calcularMedia(numeros);
        double suma = 0;
        for (double num : numeros) {
            suma += Math.pow(num - media, 2);
        }
        return suma / numeros.length;
    }

    public static double calcularDesviacionEstandar(double[] numeros) {
        return Math.sqrt(calcularVarianza(numeros));
    }

    public static double calcularRango(double[] numeros) {
        double max = Arrays.stream(numeros).max().getAsDouble();
        double min = Arrays.stream(numeros).min().getAsDouble();
        return max - min;
    }
}
