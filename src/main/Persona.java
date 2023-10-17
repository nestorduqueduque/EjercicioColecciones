package main;

public class Persona {

    private String nombres;
    private String apellidos;
    private String direccion;
    private String identificacion;
    private String telefono;
    private String sexo;
    private String programa;
    private int edad;
    private final int idPersona;
    private static int contadorPersonas;

    public Persona() {
        this.idPersona = ++contadorPersonas;
    }

    public Persona(String nombres, String apellidos, String direccion, String identificacion, String telefono, String sexo, String programa, int edad, int idPersona) {
        this();
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.identificacion = identificacion;
        this.telefono = telefono;
        this.sexo = sexo;
        this.programa = programa;
        this.edad = edad;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public static int getContadorPersonas() {
        return contadorPersonas;
    }

    public static void setContadorPersonas(int contadorPersonas) {
        Persona.contadorPersonas = contadorPersonas;
    }
    
    

}
