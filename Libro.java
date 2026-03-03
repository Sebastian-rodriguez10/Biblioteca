public class Libro {

    private String isbn;
    private String titulo;
    private String autor;
    private int añoPublicacion;
    private String estado;

    public Libro(String isbn, String titulo, String autor, int añoPublicacion, String estado) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.añoPublicacion = añoPublicacion;
        this.estado = estado;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnioPublicacion() {
        return añoPublicacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

     
    @Override
    public String toString() {
        return "\nISBN: " + isbn + "\nTítulo: " + titulo + "\nAutor: " + autor + "\nAño de Publicación: " + añoPublicacion + "\nEstado: " + estado;
    }
}
