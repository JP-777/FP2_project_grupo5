package practica;

import java.util.*;

public class JuegoMemoria {
    private static final int TAMANIO_TABLERO = 4; // Tamaño del tablero (en este caso, 4x4)
    private static final int MAX_PAREJAS = (TAMANIO_TABLERO * TAMANIO_TABLERO) / 2; // Número máximo de parejas

    private char[][] tablero = new char[TAMANIO_TABLERO][TAMANIO_TABLERO];
    private boolean[][] reveladas = new boolean[TAMANIO_TABLERO][TAMANIO_TABLERO];
    private int parejasEncontradas = 0;
    private List<Character> simbolos = Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H');

    public JuegoMemoria() {
        inicializarTablero();
        barajarTablero();
    }

    public void jugar() {
        Scanner scanner = new Scanner(System.in);
        while (parejasEncontradas < MAX_PAREJAS) {
            mostrarTablero();
            // Pedir al usuario que elija una carta
            int[] eleccion1 = obtenerEleccion(scanner);
            revelarCarta(eleccion1[0], eleccion1[1]);
            mostrarTablero();
            // Pedir al usuario que elija otra carta
            int[] eleccion2 = obtenerEleccion(scanner);
            revelarCarta(eleccion2[0], eleccion2[1]);
            mostrarTablero();
            // Comprobar si las cartas son iguales
            if (tablero[eleccion1[0]][eleccion1[1]] == tablero[eleccion2[0]][eleccion2[1]]) {
                System.out.println("¡Encontraste una pareja!");
                parejasEncontradas++;
            } else {
                System.out.println("Las cartas no coinciden. Inténtalo de nuevo.");
                ocultarCarta(eleccion1[0], eleccion1[1]);
                ocultarCarta(eleccion2[0], eleccion2[1]);
            }
        }
        System.out.println("¡Felicidades! ¡Has encontrado todas las parejas!");
        scanner.close();
    }

    private void inicializarTablero() {
        List<Character> simbolosElegidos = new ArrayList<>();
        for (int i = 0; i < MAX_PAREJAS; i++) {
            char simbolo = simbolos.get(i);
            simbolosElegidos.add(simbolo);
            simbolosElegidos.add(simbolo);
        }
        Collections.shuffle(simbolosElegidos);
        int indice = 0;
        for (int i = 0; i < TAMANIO_TABLERO; i++) {
            for (int j = 0; j < TAMANIO_TABLERO; j++) {
                tablero[i][j] = simbolosElegidos.get(indice);
                reveladas[i][j] = false;
                indice++;
            }
        }
    }

    private void barajarTablero() {
        // Barajar los símbolos en el tablero
        List<Character> tableroPlano = new ArrayList<>();
        for (int i = 0; i < TAMANIO_TABLERO; i++) {
            for (int j = 0; j < TAMANIO_TABLERO; j++) {
                tableroPlano.add(tablero[i][j]);
            }
        }
        Collections.shuffle(tableroPlano);
        // Colocar los símbolos barajados de nuevo en el tablero
        int indice = 0;
        for (int i = 0; i < TAMANIO_TABLERO; i++) {
            for (int j = 0; j < TAMANIO_TABLERO; j++) {
                tablero[i][j] = tableroPlano.get(indice);
                indice++;
            }
        }
    }

    private void mostrarTablero() {
        System.out.println("Tablero:");
        for (int i = 0; i < TAMANIO_TABLERO; i++) {
            for (int j = 0; j < TAMANIO_TABLERO; j++) {
                if (reveladas[i][j]) {
                    System.out.print(tablero[i][j] + " ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    private int[] obtenerEleccion(Scanner scanner) {
        int[] eleccion = new int[2];
        System.out.print("Ingresa la fila de la carta: ");
        eleccion[0] = scanner.nextInt() - 1; // Convertir a índice de arreglo (restar 1)

        System.out.print("Ingresa la columna de la carta: ");
        eleccion[1] = scanner.nextInt() - 1; // Convertir a índice de arreglo (restar 1)
        return eleccion;
    }

    private void revelarCarta(int fila, int columna) {
        reveladas[fila][columna] = true;
    }

    private void ocultarCarta(int fila, int columna) {
        reveladas[fila][columna] = false;
    }

    public static void main(String[] args) {
        JuegoMemoria juego = new JuegoMemoria();
        juego.jugar();
    }
}
