public class Cliente {
    private int id;
    private int  telefono;
    private String nombre;
    private String presentalibro;

    public Cliente(int id, int telefono, String presentalibro, String nombre) {
        this.id = id;
        this.telefono = telefono;
        this.nombre = nombre;
        this.presentalibro = presentalibro;
    }

    public int getId() {
        return id;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPresentalibro() {
        return presentalibro;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPresentalibro(String presentalibro) {
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
