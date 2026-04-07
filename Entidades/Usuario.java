package Entidades;
public class Usuario {

    private String documento;
    private String nombreCompleto;
    private String tipoUsuario;
    private int numPrestamos;
    private String contraseña;
    private int limPrestamos;

    public Usuario(){
    }

    public Usuario(String documento, String nombreCompleto, String tipoUsuario, String contraseña){
        this.documento=documento;
        this.nombreCompleto=nombreCompleto;
        this.tipoUsuario= tipoUsuario;
        this.contraseña= contraseña;
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
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    //get
    public String getDocumento() {
        return documento;
    }
    public String getContraseña() {
        return contraseña;
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
    if (this.numPrestamos >= this.limPrestamos) {
        System.out.println("\nEl usuario " + getNombreCompleto() + " ya tiene el máximo de préstamos.");
        return true; // ya llegó al límite
    }

    this.numPrestamos++;
    return false; // préstamo realizado correctamente
}

}
