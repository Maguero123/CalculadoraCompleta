package com.mateo.calculadoracompleta;

import com.mateo.calculadoracompleta.utils.InputUtils;
import com.mateo.calculadoracompleta.basicas.OperacionesBasicas;
import com.mateo.calculadoracompleta.algebra.Algebra;
import com.mateo.calculadoracompleta.estadistica.Estadistica;
import com.mateo.calculadoracompleta.extras.Extras;

public class Main {
    public static void main(String[] args) {
        boolean salir = false;

        while (!salir) {
            System.out.println("\n🧮 Bienvenido a la Súper Calculadora 🧮");
            System.out.println("1. Operaciones Básicas");
            System.out.println("2. Álgebra");
            System.out.println("3. Estadísticas");
            System.out.println("4. Extras");
            System.out.println("5. Salir");

            int opcion = InputUtils.leerInt("Elegí una opción: ");

            switch (opcion) {
                case 1 -> menuBasicas();
                case 2 -> menuAlgebra();
                case 3 -> menuEstadisticas();
                case 4 -> menuExtras();
                case 5 -> {
                    salir = true;
                    System.out.println("¡Gracias por usar la Súper Calculadora! 👋");
                }
                default -> System.out.println("Opción no disponible o inválida. Elegí otra.");
            }
        }
    }

    // Menú de Operaciones Básicas
    private static void menuBasicas() {
        System.out.println("\n🔢 Operaciones Básicas:");
        System.out.println("1. Sumar");
        System.out.println("2. Restar");
        System.out.println("3. Multiplicar");
        System.out.println("4. Dividir");
        System.out.println("5. Potencia");
        System.out.println("6. Raíz Cuadrada");
        System.out.println("7. Volver al menú principal");

        int opcion = InputUtils.leerInt("Elegí una opción: ");
        if (opcion == 7) return;

        double num1 = 0;
        double num2 = 0;

        if (opcion != 6) {
            num1 = InputUtils.leerDouble("Ingresá el primer número: ");
            num2 = InputUtils.leerDouble("Ingresá el segundo número: ");
        } else {
            num1 = InputUtils.leerDouble("Ingresá el número: ");
        }

        try {
            switch (opcion) {
                case 1 -> System.out.println("Resultado: " + OperacionesBasicas.sumar(num1, num2));
                case 2 -> System.out.println("Resultado: " + OperacionesBasicas.restar(num1, num2));
                case 3 -> System.out.println("Resultado: " + OperacionesBasicas.multiplicar(num1, num2));
                case 4 -> System.out.println("Resultado: " + OperacionesBasicas.dividir(num1, num2));
                case 5 -> System.out.println("Resultado: " + OperacionesBasicas.potencia(num1, num2));
                case 6 -> System.out.println("Resultado: " + OperacionesBasicas.raizCuadrada(num1));
                default -> System.out.println("Opción inválida.");
            }
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    //  Menú de Álgebra
    private static void menuAlgebra() {
        System.out.println("\n📐 Álgebra:");
        System.out.println("1. Resolver ecuación de primer grado (ax + b = 0)");
        System.out.println("2. Resolver ecuación de segundo grado (ax² + bx + c = 0)");
        System.out.println("3. Volver al menú principal");

        int opcion = InputUtils.leerInt("Elegí una opción: ");

        switch (opcion) {
            case 1 -> {
                double a = InputUtils.leerDouble("Ingresá el valor de a: ");
                double b = InputUtils.leerDouble("Ingresá el valor de b: ");
                try {
                    double resultado = Algebra.resolverEcuacionPrimerGrado(a, b);
                    System.out.println("La solución es: x = " + resultado);
                } catch (ArithmeticException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
            case 2 -> {
                double a = InputUtils.leerDouble("Ingresá el valor de a: ");
                double b = InputUtils.leerDouble("Ingresá el valor de b: ");
                double c = InputUtils.leerDouble("Ingresá el valor de c: ");
                try {
                    String resultado = Algebra.resolverEcuacionSegundoGrado(a, b, c);
                    System.out.println(resultado);
                } catch (ArithmeticException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
            case 3 -> System.out.println("Volviendo al menú principal...");
            default -> System.out.println("Opción inválida.");
        }
    }

    //  Menú de Estadísticas
    private static void menuEstadisticas() {
        System.out.println("\n📊 Estadísticas:");
        System.out.println("1. Calcular media (promedio)");
        System.out.println("2. Calcular mediana");
        System.out.println("3. Calcular moda");
        System.out.println("4. Calcular varianza");
        System.out.println("5. Calcular desviación estándar");
        System.out.println("6. Calcular rango");
        System.out.println("7. Volver al menú principal");

        int opcion = InputUtils.leerInt("Elegí una opción: ");
        if (opcion == 7) return;

        int cantidad = InputUtils.leerInt("¿Cuántos números vas a ingresar?: ");
        if (cantidad <= 0) {
            System.out.println("La cantidad debe ser mayor a cero.");
            return;
        }

        double[] numeros = new double[cantidad];
        for (int i = 0; i < cantidad; i++) {
            numeros[i] = InputUtils.leerDouble("Número " + (i + 1) + ": ");
        }

        switch (opcion) {
            case 1 -> System.out.println("Media: " + Estadistica.calcularMedia(numeros));
            case 2 -> System.out.println("Mediana: " + Estadistica.calcularMediana(numeros));
            case 3 -> System.out.println("Moda: " + Estadistica.calcularModa(numeros));
            case 4 -> System.out.println("Varianza: " + Estadistica.calcularVarianza(numeros));
            case 5 -> System.out.println("Desviación estándar: " + Estadistica.calcularDesviacionEstandar(numeros));
            case 6 -> System.out.println("Rango: " + Estadistica.calcularRango(numeros));
            default -> System.out.println("Opción inválida.");
        }
    }

    //  Menú de Extras
    private static void menuExtras() {
        System.out.println("\n🎉 Extras:");
        System.out.println("1. Calcular factorial");
        System.out.println("2. Verificar si es número primo");
        System.out.println("3. Generar números primos hasta N");
        System.out.println("4. Conversor de temperatura");
        System.out.println("5. Volver al menú principal");
        System.out.println("6. Conversor de unidades (longitud, peso, tiempo)");

        int opcion = InputUtils.leerInt("Elegí una opción: ");

        switch (opcion) {
            case 1 -> {
                int n = InputUtils.leerInt("Ingresá un número entero: ");
                try {
                    long resultado = Extras.factorial(n);
                    System.out.println("El factorial de " + n + " es: " + resultado);
                } catch (ArithmeticException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
            case 2 -> {
                int n = InputUtils.leerInt("Ingresá un número entero: ");
                if (Extras.esPrimo(n)) {
                    System.out.println(n + " es un número primo.");
                } else {
                    System.out.println(n + " NO es un número primo.");
                }
            }
            case 3 -> {
                int n = InputUtils.leerInt("Generar primos hasta: ");
                Extras.generarPrimosHasta(n);
            }
            case 4 -> menuConversorTemperatura();
            case 5 -> System.out.println("Volviendo al menú principal...");
            case 6 -> menuConversorUnidades();
            default -> System.out.println("Opción inválida.");
        }
    }

    private static void menuConversorTemperatura() {
        System.out.println("\n🌡️ Conversor de Temperatura:");
        System.out.println("1. Celsius a Fahrenheit");
        System.out.println("2. Celsius a Kelvin");
        System.out.println("3. Fahrenheit a Celsius");
        System.out.println("4. Kelvin a Celsius");
        System.out.println("5. Volver");

        int opcion = InputUtils.leerInt("Elegí una opción: ");
        if (opcion == 5) return;

        double valor = InputUtils.leerDouble("Ingresá el valor: ");
        switch (opcion) {
            case 1 -> System.out.println(valor + " °C = " + Extras.celsiusAFahrenheit(valor) + " °F");
            case 2 -> System.out.println(valor + " °C = " + Extras.celsiusAKelvin(valor) + " K");
            case 3 -> System.out.println(valor + " °F = " + Extras.fahrenheitACelsius(valor) + " °C");
            case 4 -> System.out.println(valor + " K = " + Extras.kelvinACelsius(valor) + " °C");
            default -> System.out.println("Opción inválida.");
        }
    }

    private static void menuConversorUnidades() {
        System.out.println("\n🧭 Conversor de Unidades:");
        System.out.println("1. Longitud");
        System.out.println("2. Peso");
        System.out.println("3. Tiempo");
        System.out.println("4. Volver");
    
        int opcion = InputUtils.leerInt("Elegí una opción: ");
        switch (opcion) {
            case 1 -> conversorLongitud();
            case 2 -> conversorPeso();
            case 3 -> conversorTiempo();
            case 4 -> System.out.println("Volviendo...");
            default -> System.out.println("Opción inválida.");
        }
    }
    
    private static void conversorLongitud() {
        System.out.println("\n📏 Conversor de Longitud:");
        System.out.println("1. Metros a Kilómetros");
        System.out.println("2. Kilómetros a Metros");
        System.out.println("3. Metros a Centímetros");
        System.out.println("4. Centímetros a Metros");
        System.out.println("5. Volver");
    
        int opcion = InputUtils.leerInt("Elegí una opción: ");
        if (opcion == 5) return;
    
        double valor = InputUtils.leerDouble("Ingresá el valor: ");
        switch (opcion) {
            case 1 -> System.out.println(valor + " metros = " + Extras.metrosAKilometros(valor) + " km");
            case 2 -> System.out.println(valor + " km = " + Extras.kilometrosAMetros(valor) + " metros");
            case 3 -> System.out.println(valor + " metros = " + Extras.metrosACentimetros(valor) + " cm");
            case 4 -> System.out.println(valor + " cm = " + Extras.centimetrosAMetros(valor) + " metros");
            default -> System.out.println("Opción inválida.");
        }
    }
    
    private static void conversorPeso() {
        System.out.println("\n⚖️ Conversor de Peso:");
        System.out.println("1. Kilogramos a Gramos");
        System.out.println("2. Gramos a Kilogramos");
        System.out.println("3. Kilogramos a Libras");
        System.out.println("4. Libras a Kilogramos");
        System.out.println("5. Volver");
    
        int opcion = InputUtils.leerInt("Elegí una opción: ");
        if (opcion == 5) return;
    
        double valor = InputUtils.leerDouble("Ingresá el valor: ");
        switch (opcion) {
            case 1 -> System.out.println(valor + " kg = " + Extras.kilogramosAGramos(valor) + " g");
            case 2 -> System.out.println(valor + " g = " + Extras.gramosAKilogramos(valor) + " kg");
            case 3 -> System.out.println(valor + " kg = " + Extras.kilogramosALibras(valor) + " lb");
            case 4 -> System.out.println(valor + " lb = " + Extras.librasAKilogramos(valor) + " kg");
            default -> System.out.println("Opción inválida.");
        }
    }
    
    private static void conversorTiempo() {
        System.out.println("\n⏱️ Conversor de Tiempo:");
        System.out.println("1. Horas a Minutos");
        System.out.println("2. Minutos a Horas");
        System.out.println("3. Minutos a Segundos");
        System.out.println("4. Segundos a Minutos");
        System.out.println("5. Volver");
    
        int opcion = InputUtils.leerInt("Elegí una opción: ");
        if (opcion == 5) return;
    
        double valor = InputUtils.leerDouble("Ingresá el valor: ");
        switch (opcion) {
            case 1 -> System.out.println(valor + " horas = " + Extras.horasAMinutos(valor) + " minutos");
            case 2 -> System.out.println(valor + " minutos = " + Extras.minutosAHoras(valor) + " horas");
            case 3 -> System.out.println(valor + " minutos = " + Extras.minutosASegundos(valor) + " segundos");
            case 4 -> System.out.println(valor + " segundos = " + Extras.segundosAMinutos(valor) + " minutos");
            default -> System.out.println("Opción inválida.");
        }
    }
    
}
