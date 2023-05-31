public class ListaDoblementeLigada {

    private NodoDoble cabeza, cola, iterador;

    public ListaDoblementeLigada() {
        cabeza = new NodoDoble();
        cola = iterador = cabeza;
    }

    public void agregarParticipante(Participante participante) {
        NodoDoble nuevoNodo = new NodoDoble(participante);
        cola.setSiguiente(nuevoNodo);
        nuevoNodo.setAnterior(cola);
        cola = nuevoNodo;
    }

    public Participante recorrerHaciaDerecha() {
        iterador = iterador.getSiguiente();
        if (iterador == null) {
            iterador = cabeza;
        }
        return iterador.getParticipante();
    }

    public void ordenarPorEdad() {
        if (cabeza.getSiguiente() == null || cabeza.getSiguiente().getSiguiente() == null) {
            return; // No hay elementos o solo hay uno, no es necesario ordenar
        }
        boolean intercambioRealizado;
        do {
            NodoDoble actual = cabeza.getSiguiente();
            NodoDoble siguiente = actual.getSiguiente();
            intercambioRealizado = false;
            while (siguiente != null) {
                if (actual.getParticipante().getEdad() > siguiente.getParticipante().getEdad()) {
                    intercambioRealizado = true;
                    actual.getAnterior().setSiguiente(siguiente);            
                    siguiente.setAnterior(actual.getAnterior());                
                    actual.setAnterior(siguiente);
                    actual.setSiguiente(siguiente.getSiguiente());
                    if (siguiente.getSiguiente() != null) {
                        siguiente.getSiguiente().setAnterior(actual);
                    }
                    siguiente.setSiguiente(actual);
                    siguiente = siguiente.getSiguiente();
                } else {
                    actual = siguiente;
                    siguiente = siguiente.getSiguiente();
                }
            }
        } while (intercambioRealizado);
    }

    // public void generarPilas() {
    // Pila pilaHombres = new Pila();
    // Pila pilaMujeres = new Pila();

    // NodoDoble actual = cabeza;
    // while (actual != null) {
    // Participante participante = actual.getParticipante();
    // if (participante.getSexo().equalsIgnoreCase("m")) {
    // pilaHombres.push(participante.getNombre());
    // } else if (participante.getSexo().equalsIgnoreCase("f")) {
    // pilaMujeres.push(participante.getNombre());
    // }
    // actual = actual.getSiguiente();
    // }
}