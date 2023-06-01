
public class Pila {

   private NodoSimple primero, ultimo, iterador;

   public Pila() {
      ultimo = new NodoSimple(null);
      primero = iterador = ultimo;
   }

   public void apilar(String pNombre){
      NodoSimple newNodo = new NodoSimple(pNombre);
      newNodo.setLiga(primero);
      primero = newNodo;
   }

   public String desapilar(){
      String nombre = primero.getNombre();
      primero = primero.getLiga();
      return nombre;
   }

}
