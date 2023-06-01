

public class NodoSimple {

   private String nombre;
   private NodoSimple liga;

   public NodoSimple(String pNombre) {
       nombre = pNombre;
       liga = null;
   }

   public String getNombre() {
       return nombre;
   }

   public void setNombre(String pNombre) {
       this.nombre = pNombre;
   }

   public NodoSimple getLiga() {
       return liga;
   }

   public void setLiga(NodoSimple liga) {
       this.liga = liga;
   }
   
}
