# Súper Calculadora Completa

## Descripción

Esta aplicación es una calculadora completa desarrollada en Java utilizando JavaFX para la interfaz gráfica de usuario. Permite realizar diferentes tipos de cálculos, desde operaciones básicas hasta estadísticas, álgebra y funciones extras como cálculo de factorial, números primos y conversor de temperatura.

La aplicación cuenta con un menú principal desde donde se puede acceder a cada uno de los módulos y volver al menú en cualquier momento.

## Funcionalidades

### Operaciones Básicas
- Suma
- Resta
- Multiplicación
- División (con validación de división por cero)
- Potencia
- Raíz cuadrada

### Álgebra
- Resolución de ecuaciones cuadráticas de la forma `ax² + bx + c = 0`
- Ingreso de la ecuación como texto (ejemplo: `2x² - 5x + 3 = 0`)
- Muestra las soluciones reales o indica si las raíces son imaginarias

### Estadísticas
- Media (promedio)
- Mediana
- Moda
- Varianza
- Desviación estándar
- Rango

### Extras
- Cálculo de factorial
- Verificación de si un número es primo
- Generación de números primos hasta N
- Conversor de temperatura de Celsius a Fahrenheit

## Requisitos

- JDK 17 o superior (se recomienda JDK 21)
- JavaFX SDK (utilizado: `openjfx-21.0.6`)

## Cómo compilar y ejecutar

### 1. Configuración en VS Code

- Asegurarse de tener las siguientes extensiones instaladas:
  - Extension Pack for Java
  - JavaFX Support (opcional)

- Configurar el archivo `settings.json`:

```json
{
    "java.project.referencedLibraries": [
        "C:/Users/mateo/Downloads/openjfx-21.0.6_windows-x64_bin-sdk/javafx-sdk-21.0.6/lib/*.jar"
    ]
}
```

- Configurar `.vscode/tasks.json` para compilar:

```json
{
    "version": "2.0.0",
    "tasks": [
        {
            "label": "Compilar JavaFX",
            "type": "shell",
            "command": "javac",
            "args": [
                "--module-path",
                "C:/Users/mateo/Downloads/openjfx-21.0.6_windows-x64_bin-sdk/javafx-sdk-21.0.6/lib",
                "--add-modules",
                "javafx.controls",
                "-d",
                "out",
                "src/com/mateo/calculadoracompleta/gui/*.java"
            ],
            "group": {
                "kind": "build",
                "isDefault": true
            },
            "problemMatcher": []
        }
    ]
}
```

- Configurar `.vscode/launch.json` para ejecutar:

```json
{
    "version": "0.2.0",
    "configurations": [
        {
            "type": "java",
            "name": "Ejecutar Súper Calculadora GUI",
            "request": "launch",
            "mainClass": "com.mateo.calculadoracompleta.gui.MainGUI",
            "vmArgs": "--module-path C:/Users/mateo/Downloads/openjfx-21.0.6_windows-x64_bin-sdk/javafx-sdk-21.0.6/lib --add-modules javafx.controls"
        }
    ]
}
```

### 2. Compilación

Presionar `Ctrl + Shift + B` y elegir **Compilar JavaFX**.

### 3. Ejecución

Usar el botón verde de Run (▶️) en VS Code y seleccionar **Ejecutar Súper Calculadora GUI**.

## Estructura del proyecto

```
CalculadoraCompleta/
├── src/
│   └── com/
│       └── mateo/
│           └── calculadoracompleta/
│               └── gui/
│                   ├── MainGUI.java
│                   ├── OperacionesBasicasGUI.java
│                   ├── CalculadoraAlgebraGUI.java
│                   ├── EstadisticasGUI.java
│                   └── ExtrasGUI.java
├── out/
├── .vscode/
│   ├── tasks.json
│   └── launch.json
├── settings.json
└── README.md
```

## Autor

Mateo (Proyecto: Súper Calculadora Completa)
