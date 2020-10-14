package Clases;

public class Student {

    private int cui;
    private String nombres;
    private String apellidos;

    public Student(int cui,String nombres,String apellidos){
        this.cui=cui;
        this.nombres=nombres;
        this.apellidos=apellidos;
    }

    public int getCui() {
        return cui;
    }

    public String getNombres() {
        return nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
}
