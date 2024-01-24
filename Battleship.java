import java.util.Scanner;

public class Battleship {
    public static void main(String[] args) {
        Scanner teclat = new Scanner(System.in);
        int f = 10, c = 10;
        char tableroJuego[][] = new char[f][c];
        char tableroBarcos[][] = new char[f][c];
        menu(tableroJuego,tableroBarcos);
    }

    public static void crearTablero(char[][] tabla) {

        for (int i = 0; i < tabla.length; i++) {
            for (int j = 0; j < tabla.length; j++) {
                tabla[i][j] = '-';
            }
        }
    }// Fin de crear tablero

    public static void mostrarTablero(char[][] t) {
        int num = 0;
        char letras = 'A';

        for (int i = 0; i < t.length; i++) {
            System.out.print("\t" + num++);

        }

        for (int i = 0; i < t.length; i++) {
            System.out.println();
            System.out.print(letras++ + "\t");
            for (int j = 0; j < t.length; j++) {
                System.out.print(t[i][j] + "\t");
            }
        }

    }// Fin de mostrarTablero

    public static void insertarLancha(char [][] tablasB) {

        int Pos1 = 0;
        int Pos2 = 0;

            Pos1 = (int) (Math.random() * (10));
            Pos2 = (int) (Math.random() * (10));
            tablasB[Pos1][Pos2] = 'L';


    }// Fin lancha

    public static void insertarbarco(char[][] tablaB) {

int fila,columna;
        do{
            fila = (int)(Math.random()* (10));
            columna = (int)(Math.random()* (8));

        }while(tablaB[fila][columna]!='-' || tablaB[fila][columna+1]!='-' || tablaB[fila][columna+2]!='-');

         tablaB[fila][columna]='B';
         tablaB[fila][columna+1]='B';
         tablaB[fila][columna+2]='B';

    }//FIn insertarBarcos
    public static void insertarPotaviones(char[][] tablarPort){// inici de insertar Portaviones
        int fila,columna;

        do{
            fila = (int)(Math.random()* (10));
            columna = (int)(Math.random()* (7));
        }while(tablarPort[fila][columna] !='-' || tablarPort[fila][columna+1] !='-' || tablarPort[fila][columna+2] !='-' || tablarPort[fila][columna+3] !='-' );

            tablarPort[fila][columna]= 'Z';
            tablarPort[fila][columna+1]= 'Z';
            tablarPort[fila][columna+2]= 'Z';
            tablarPort[fila][columna+3]= 'Z';

        // FIn primer for

    }// Fin de insertarPortaviones

    public static void insertarAcorazado (char [][] tablaAcora){

        int fila,columna;
        do{
            fila = (int)(Math.random()* (6));
            columna = (int)(Math.random()* (10));

        }while( tablaAcora[fila][columna] !='-' || tablaAcora[fila+1][columna] !='-' || tablaAcora[fila+2][columna] !='-' || tablaAcora[fila+3][columna] !='-' || tablaAcora[fila+4][columna]!= '-' );

            tablaAcora[fila][columna]= 'P';
            tablaAcora[fila+1][columna]= 'P';
            tablaAcora[fila+2][columna]= 'P';
            tablaAcora[fila+3][columna]= 'P';
            tablaAcora[fila+4][columna]= 'P';

    }// Fin del insertarAcorazado
        public static void disparar (char [][] tablerJuego, char[][] tableroBarcos){

        Scanner teclat = new Scanner (System.in);

            System.out.println("Dime la fila");
            int fila = teclat.nextInt();
            System.out.println("Dime la columna");
            int columna = teclat.nextInt();

            if (tableroBarcos[fila][columna] !='-') {
                tablerJuego[fila][columna]='X';
            }else {
                tablerJuego[fila][columna]='A';
            }
        }// FIn disparar

    public static void menu (char [][] tableroJuego, char [][] tableroBarcos){
        Scanner teclat = new Scanner(System.in);
        int contador = 0;

        System.out.println("Nivell de dificultat");
        System.out.println(" 1- Nivell facil");
        System.out.println(" 2- Nivell Mitjà");
        System.out.println(" 3- Nivell Difícil");
        System.out.println(" 4-Nivell Personalitzat");
        System.out.println("Dime la opción que quieras");
        int opcio= teclat.nextInt();

        switch (opcio){

            case 1:

                crearTablero(tableroJuego);// Creas el tablero del juego
                crearTablero(tableroBarcos); // Crea el tablero de los juegos
                insertarLancha(tableroBarcos);// Pone los barcos en el tablero.
                insertarLancha(tableroBarcos);
                insertarLancha(tableroBarcos);
                insertarLancha(tableroBarcos);
                insertarLancha(tableroBarcos);
                insertarbarco(tableroBarcos);
                insertarbarco(tableroBarcos);
                insertarbarco(tableroBarcos);
                insertarPotaviones(tableroBarcos); // Pone los Portaviones en el tablero
                insertarAcorazado(tableroBarcos); // Pone los acorazados en el tablero
                mostrarTablero(tableroBarcos); // muestra el tablero de los barcos
                System.out.println();
                System.out.println();
                mostrarTablero(tableroJuego); // muestra el tablero de juego
                System.out.println();
                for (int i = 0; i < 50; i++) {
                    contador++;
                    disparar(tableroJuego,tableroBarcos);// dispara a los barcos
                    mostrarTablero(tableroJuego);// muestra la tabla del jugador por si a dado a un barco
                    System.out.println();
                    System.out.println("has utilizado" +contador+"/50");
                }

            case 2:
                crearTablero(tableroJuego);// Creas el tablero del juego
                crearTablero(tableroBarcos); // Crea el tablero de los juegos
                insertarLancha(tableroBarcos);// Pone los barcos en el tablero.
                insertarLancha(tableroBarcos);
                insertarbarco(tableroBarcos);
                insertarPotaviones(tableroBarcos);// Pone los Portaviones en el tablero
                insertarAcorazado(tableroBarcos);// Pone los acorazados en el tablero
                mostrarTablero(tableroBarcos);// muestra el tablero de los barcos
                System.out.println();
                System.out.println();
                mostrarTablero(tableroJuego);// muestra el tablero de juego
                System.out.println();
                for (int i = 0; i < 30; i++) {
                    contador++;
                    disparar(tableroJuego,tableroBarcos);// dispara a los barcos
                    mostrarTablero(tableroJuego);// muestra la tabla del jugador por si a dado a un barco
                    System.out.println();
                    System.out.println("has utilizado" +contador+"/30");
                }

            case 3:
                crearTablero(tableroJuego);// Creas el tablero del juego
                crearTablero(tableroBarcos); // Crea el tablero de los juegos
                insertarLancha(tableroBarcos);// Pone los barcos en el tablero.
                insertarbarco(tableroBarcos);
                mostrarTablero(tableroBarcos);// muestra el tablero de los barcos
                System.out.println();
                System.out.println();
                mostrarTablero(tableroJuego);// muestra el tablero de juego
                System.out.println();
                for (int i = 0; i < 10; i++) {
                    contador++;
                    disparar(tableroJuego,tableroBarcos);// dispara a los barcos
                    mostrarTablero(tableroJuego);// muestra la tabla del jugador por si a dado a un barco
                    System.out.println();
                    System.out.println("has utilizado" +contador+"/10");
                }

            case 4:

        }
    }

}// Fin del main ALVARO

