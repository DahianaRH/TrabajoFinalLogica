public class ListaDoblementeLigada {

    private NodoDoble cabeza, cola, iterador;

    public ListaDoblementeLigada() {
        cabeza = new NodoDoble();
        cola = iterador = cabeza;
    }

    public String agregarParticipante(Participante participante) {
        NodoDoble nuevoNodo = new NodoDoble(participante);
        cola.setSiguiente(nuevoNodo);
        nuevoNodo.setAnterior(cola);
        cola = nuevoNodo;
        return "Participante agregado satisfactoriamente!";
    }

    public Participante recorrerHaciaDerecha() {
        iterador = iterador.getSiguiente();
        if (iterador == null) {
            iterador = cabeza;
        }
        return iterador.getParticipante();
    }

    public String ordenarPorEdad() {
        if (cabeza.getSiguiente() == null || cabeza.getSiguiente().getSiguiente() == null) {
            return "Lista vacía o con sólo un participante. No se requiere ordenar!";
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
        return "Lista ordenada satisfactoriamente!";
    }

    public Pila generarPilaPorSexo(String sexo) {
        Pila nuevaPila = new Pila();
        Participante participante = this.recorrerHaciaDerecha();
        while (participante != null) {
            if (participante.getEdad() > 18 && participante.getSexo().equalsIgnoreCase(sexo)) {
                nuevaPila.apilar(participante.getNombre());
            }
            participante = this.recorrerHaciaDerecha();
        }
        return nuevaPila;
    }

}