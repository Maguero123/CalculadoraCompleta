package com.mateo.calculadoracompleta.utils;

import java.util.Scanner;

public class InputUtils {
    private static final Scanner scanner = new Scanner(System.in);

    public static double leerDouble(String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextDouble()) {
            System.out.println("Entrada inválida. Por favor, ingresá un número.");
            scanner.next();
        }
        return scanner.nextDouble();
    }

    public static int leerInt(String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida. Por favor, ingresá un número entero.");
            scanner.next();
        }
        return scanner.nextInt();
    }
}
