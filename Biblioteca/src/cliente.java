public class cliente {
    private int id;
    private int  telefono;
    private String direccion;
    private String nombre;
    private boolean presentalibro;

    public cliente(int id, int telefono, boolean presentalibro, String nombre,String direccion ) {
        this.id = id;
        this.telefono = telefono;
        this.direccion = direccion;
        this.nombre = nombre;
        this.presentalibro = presentalibro;
    }

    public int getId() {
        return id;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isPresentalibro() {
        return presentalibro;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPresentalibro(boolean presentalibro) {
        this.presentalibro = presentalibro;
    }

    public void mostrarinformacion (){
        System.out.println(id);
        System.out.println(telefono);
        System.out.println(direccion);
        System.out.println(nombre);
        System.out.println(presentalibro);
    }
}
