package Entidades;
public class Usuario {

    private String documento;
    private String nombreCompleto;
    private String tipoUsuario;

    public Usuario(){
    }

    public Usuario(String documento, String nombreCompleto, String tipoUsuario){
        this.documento=documento;
        this.nombreCompleto=nombreCompleto;
        this.tipoUsuario= tipoUsuario;
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
}
