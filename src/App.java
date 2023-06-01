import java.util.Scanner;

public class App {

    public static ListaDoblementeLigada listaParticpantes = new ListaDoblementeLigada();
    public static Pila pilaHombres = new Pila();
    public static Pila pilaMujeres = new Pila();
    public static Pila pilaHombresAuxiliar = new Pila();

    public static void main(String[] args) throws Exception {

        Scanner lector = new Scanner(System.in);
        char opcion;
        int edad;
        String sexo, nombre;

        ingresarDatosIniciales();

        do {
            opcion = menu();
            switch (opcion) {
                case '1':
                    System.out.println("\n\t\t ---> Ingrese información del participante: ");
                    System.out.print("\t\t\t Nombre: ");
                    nombre = lector.nextLine();
                    System.out.print("\t\t\t Sexo (f o m): ");
                    sexo = lector.nextLine();
                    System.out.print("\t\t\t Edad: ");
                    edad = lector.nextInt();
                    lector.nextLine();
                    System.out.println("\n\t\t" + listaParticpantes.agregarParticipante(new Participante(nombre, sexo, edad)));
                    break;
                case '2':
                    System.out.println();
                    imprimirLista();
                    break;
                case '3':
                    System.out.println("\n\t\t" + listaParticpantes.ordenarPorEdad());
                    break;
                case '4':
                    System.out.println();
                    pilaHombres = listaParticpantes.generarPilaPorSexo("M");
                    pilaMujeres = listaParticpantes.generarPilaPorSexo("F");
                    intercambiarPila(pilaHombres, pilaHombresAuxiliar);
                    desapilarCompleto(pilaHombresAuxiliar, pilaMujeres);
                    break;
                case '5':
                    System.out.println("\n\t Usted ha salido del sistema! \n");
            }

        } while (opcion != '5');
    }

    static char menu() {
        char menu;
        Scanner lector = new Scanner(System.in);
        System.out.println("\n\n\t    MENÚ DE OPCIONES  ");
        System.out.println("\t1. Ingresar un nuevo concursante.");
        System.out.println("\t2. Mostrar lista completa de inscritos.");
        System.out.println("\t3. Ordenar lista de inscritos.");
        System.out.println("\t4. Mostrar pareja de concursantes que cumplen requisitos de inscripción.");
        System.out.println("\t5. Salir.");
        do {
            System.out.println("");
            System.out.print("\t Ingrese la opción deseada: ");
            menu = lector.next().charAt(0);
            lector.nextLine();
        } while (menu < '1' || menu > '5');
        return menu;
    }

    public static void ingresarDatosIniciales() {
        listaParticpantes.agregarParticipante(new Participante("Julián Rodríguez", "M", 30));
        listaParticpantes.agregarParticipante(new Participante("Jhon Rodríguez", "M", 27));
        listaParticpantes.agregarParticipante(new Participante("Miguel Rodríguez", "M", 33));
        listaParticpantes.agregarParticipante(new Participante("Margarita Arboleda", "F", 39));
        listaParticpantes.agregarParticipante(new Participante("Sandy Dahiana", "F", 26));
        listaParticpantes.agregarParticipante(new Participante("Fanny Guerra", "F", 56));
        listaParticpantes.agregarParticipante(new Participante("Mateo Arboleda", "M", 16));
        listaParticpantes.agregarParticipante(new Participante("Luis Gomez", "M", 17));
    }

    public static void imprimirLista() {
        Participante participante = listaParticpantes.recorrerHaciaDerecha();
        while (participante != null) {
            System.out.println("\t\t" + participante);
            participante = listaParticpantes.recorrerHaciaDerecha();
        }
    }

    public static void desapilarCompleto(Pila pilaHombres, Pila pilaMujeres) {
        String nombreHombre = pilaHombres.desapilar();
        String nombreMujer = pilaMujeres.desapilar();
        while (nombreHombre != null && nombreMujer != null) {
            System.out.println("\t\t Hombre: " + nombreHombre + " - Mujer: " + nombreMujer);
            nombreHombre = pilaHombres.desapilar();
            nombreMujer = pilaMujeres.desapilar();
        }
    }

    public static void intercambiarPila(Pila primeraPila, Pila segundaPila) {
        String nombre = primeraPila.desapilar();
        while (nombre != null) {
            segundaPila.apilar(nombre);
            nombre = primeraPila.desapilar();
        }
    }

}