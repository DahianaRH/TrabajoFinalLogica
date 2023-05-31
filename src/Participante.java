public class Participante {

    private String nombre;
    private String sexo;
    private int edad;

    public Participante(String nombre, String sexo, int edad) {
        this.nombre = nombre;
        this.sexo = sexo;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return "Participante [nombre=" + nombre + ", sexo=" + sexo + ", edad=" + edad + "]";
    }

}