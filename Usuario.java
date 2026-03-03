public class Usuario {

    private int documento;
    private String nombreCompleto;
    private String tipoUsuario;

    public Usuario(){
    }

    public Usuario(int documento, String nombreCompleto, String tipoUsuario){
        this.documento=documento;
        this.nombreCompleto=nombreCompleto;
        this.tipoUsuario= tipoUsuario;
    }
    //Set 
    public void setDocumento(int documento) {
        this.documento = documento;
    }
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    //get
    public int getDocumento() {
        return documento;
    }
    public String getNombreCompleto() {
        return nombreCompleto;
    }
    public String getTipoUsuario() {
        return tipoUsuario;
    }
}
