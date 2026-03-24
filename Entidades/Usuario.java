package Entidades;
public class Usuario {

    private String documento;
    private String nombreCompleto;
    private String tipoUsuario;
    private int numPrestamos;
    private int limPrestamos;

    public Usuario(){
    }

    public Usuario(String documento, String nombreCompleto, String tipoUsuario){
        this.documento=documento;
        this.nombreCompleto=nombreCompleto;
        this.tipoUsuario= tipoUsuario;
        this.numPrestamos = 0;
        this.limPrestamos = 3;
    }
    //Set 
    public void setDocumento(String documento) {
        this.documento = documento;
    }
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    //get
    public String getDocumento() {
        return documento;
    }
    public String getNombreCompleto() {
        return nombreCompleto;
    }
    public String getTipoUsuario() {
        return tipoUsuario;
    }
    public int getNumPrestamos() {
        return numPrestamos;
    }
    public int getLimPrestamos() {
        return limPrestamos;
    }
    //Nuevo métodos:
    public boolean incrementarPrestamos() {
        this.numPrestamos = this.numPrestamos + 1;
        boolean aviso = false;
        if(this.numPrestamos > this.limPrestamos) {
            System.out.println("\nEl usuario " + getNombreCompleto() + " ya tiene prestados 3 libros.");
            aviso = true; //Cuando este dato boolean tiene como valor 'true', significa que el usuario ya tiene 3 prestamos. 
        }
        return aviso;
    }

}
