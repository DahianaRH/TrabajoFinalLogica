public class NodoDoble {
    private Participante participante;
    private NodoDoble siguiente;
    private NodoDoble anterior;

    public NodoDoble(Participante participante) {
        this.participante = participante;
        this.siguiente = null;
        this.anterior = null;
    }

    public Participante getParticipante() {
        return participante;
    }

    public NodoDoble getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoDoble siguiente) {
        this.siguiente = siguiente;
    }

    public NodoDoble getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoDoble anterior) {
        this.anterior = anterior;
    }
}
