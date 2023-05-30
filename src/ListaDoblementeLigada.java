public class ListaDoblementeLigada {
    private NodoDoble cabeza;
    private NodoDoble cola;

    public ListaDoblementeLigada() {
        this.cabeza = null;
        this.cola = null;
    }

    public void agregarParticipante(Participante participante) {
        if (participante.getEdad() >= 18) {
            NodoDoble nuevoNodo = new NodoDoble(participante);
            if (cabeza == null) {
                cabeza = nuevoNodo;
                cola = nuevoNodo;
            } else {
                nuevoNodo.setAnterior(cola);
                cola.setSiguiente(nuevoNodo);
                cola = nuevoNodo;
            }
        }
    }

    public void ordenarPorEdad() {
        if (cabeza == null || cabeza.getSiguiente() == null) {
            return; // No hay elementos o solo hay uno, no es necesario ordenar
        }

        boolean intercambioRealizado;
        do {
            NodoDoble actual = cabeza;
            NodoDoble siguiente = cabeza.getSiguiente();
            intercambioRealizado = false;

            while (siguiente != null) {
                if (actual.getParticipante().getEdad() > siguiente.getParticipante().getEdad()) {
                    intercambioRealizado = true;

                    if (actual.getAnterior() != null) {
                        actual.getAnterior().setSiguiente(siguiente);
                    } else {
                        cabeza = siguiente;
                    }

                    siguiente.setAnterior(actual.getAnterior());
                    actual.setAnterior(siguiente);
                    actual.setSiguiente(siguiente.getSiguiente());

                    if (siguiente.getSiguiente() != null) {
                        siguiente.getSiguiente().setAnterior(actual);
                    }

                    siguiente.setSiguiente(actual);
                    siguiente = actual.getSiguiente();
                } else {
                    actual = siguiente;
                    siguiente = siguiente.getSiguiente();
                }
            }
        } while (intercambioRealizado);
    }

    /*public void generarPilas() {
        Pila pilaHombres = new Pila();
        Pila pilaMujeres = new Pila();

        NodoDoble actual = cabeza;
        while (actual != null) {
            Participante participante = actual.getParticipante();
            if (participante.getSexo().equalsIgnoreCase("m")) {
                pilaHombres.push(participante.getNombre());
            } else if (participante.getSexo().equalsIgnoreCase("f")) {
                pilaMujeres.push(participante.getNombre());
            }
            actual = actual.getSiguiente();
        }*/
}