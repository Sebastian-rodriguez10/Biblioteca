package Entidades;

public class Prestamo {
    private Usuario usuario;
    private Libro libro;
    private boolean estado;

    public Prestamo() {

    }

    public Prestamo(Usuario usuario, Libro libro, boolean estado) {
        this.usuario = usuario;
        this.libro = libro;
        this.estado = estado;
    }

    public void setUsuario(Usuario usuario) { 
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setLibro(Libro libro) { 
        this.libro = libro;
    }

    public Libro getLibro() {
        return libro;
    }


    public void setEstado(boolean estado) { 
        this.estado = estado;
    }

    public boolean isEstado() {
        return estado;
    }

}