package org.example;

import java.util.Scanner;

public class ventaBoletos {

    private static int nFilas;
    private static int mColumnas;
    private static double valorBoletos = 19500.0;
    private static String[][] matrizAsientos;
    private static double totalVentas = 0.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido al sistema de venta de boletos");
        System.out.println("¿cuantas filas tiene el bus?");
        nFilas = scanner.nextInt();
        System.out.println("¿cuantas columnas tiene el bus?");
        mColumnas = scanner.nextInt();
        inicializarMatriz();
        mostrarMatriz();
        comprarBoletos(scanner);

    }//inicializar la matriz
    public static void inicializarMatriz() {
        matrizAsientos = new String[nFilas][mColumnas];
        int numeroAsientos = 1;
        for(int i = 0 ; i < nFilas; i++){
            for (int j = 0; j < mColumnas; j++){
                matrizAsientos[i][j] = String.valueOf(numeroAsientos);
                        numeroAsientos++;
            }
        }
    }

    //Mostrar matriz
    public static void mostrarMatriz(){
        System.out.println("matriz de asientos");
        for (int i = 0; i < nFilas; i++) {
            for (int j = 0; j < mColumnas; j++) {
                System.out.print(matrizAsientos[i][j] + "\t");
            }
            System.out.println();
        }
    }

    //comprar boletos
    private static void comprarBoletos(Scanner scanner) {
        while (true) {
            System.out.println("Ingrese el número de asiento que desea comprar:");
            int numeroAsientos = scanner.nextInt();

            if (numeroAsientos == -1) {
                System.out.println("Saliendo del proceso de compra de boletos...");
                break; // Salir del bucle
            }

            int fila = (numeroAsientos - 1) / mColumnas;
            int columna = (numeroAsientos - 1) % mColumnas;

            if (numeroAsientos < 1 || numeroAsientos > nFilas * mColumnas || numeroAsientos < 1) {
                System.out.println("Número de asiento inválido");
                continue; // Volver al inicio del bucle para permitir otro intento
            }

            if ("X".equals(matrizAsientos[fila][columna])) {
                System.out.println("El asiento seleccionado ya está ocupado");
                continue; // Volver al inicio del bucle para permitir otro intento
            }

            matrizAsientos [fila][columna] = "X";
            totalVentas += valorBoletos;
            System.out.println("Compra realizada con éxito");
            System.out.println("Total de ventas realizadas: $" + totalVentas);
            mostrarMatriz();

            // Preguntar si quiere comprar otro pasaje
            System.out.println("¿Desea comprar otro pasaje? (Sí/No):");
            String respuesta = scanner.next().toLowerCase();
            if (!respuesta.equals("sí") && !respuesta.equals("si")) {
                System.out.println("Saliendo del proceso de compra de boletos...");
                break; // Salir del bucle si la respuesta no es "sí" o "si"
            }
        }

    }

}

