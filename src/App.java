public class App {

    public static ListaDoblementeLigada listaParticpantes = new ListaDoblementeLigada();

    public static void main(String[] args) throws Exception {
        ingresarDatos();
        listaParticpantes.ordenarPorEdad();
        imprimirLista();

    }

    public static void ingresarDatos() {
        listaParticpantes.agregarParticipante(new Participante("Julián Rodríguez", "M", 30));
        listaParticpantes.agregarParticipante(new Participante("Jhon Rodríguez", "M", 27));
        listaParticpantes.agregarParticipante(new Participante("Miguel Rodríguez", "M", 33));
        listaParticpantes.agregarParticipante(new Participante("Margarita Arboleda", "F", 39));
        listaParticpantes.agregarParticipante(new Participante("Sandy Dahiana", "F", 26));
        listaParticpantes.agregarParticipante(new Participante("Fanny Guerra", "F", 56));
        listaParticpantes.agregarParticipante(new Participante("Mateo Arboleda", "M", 16));
    }

    public static void imprimirLista() {
        Participante participante = listaParticpantes.recorrerHaciaDerecha();
        while (participante != null) {
            System.out.println(participante);
            participante = listaParticpantes.recorrerHaciaDerecha();
        }

    }

}