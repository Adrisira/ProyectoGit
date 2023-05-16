package examen2023;

public class Periodico extends MaterialBibliografico{
	 private String fechaPublicacion;
	    
	    public Periodico(String titulo, String autor, int anoPublicacion, String fechaPublicacion) {
	        super(titulo, autor, anoPublicacion);
	        this.fechaPublicacion = fechaPublicacion;
	    }
	    
	    public String toString() {
	        return super.toString()+"\nFecha de publicación: " + this.fechaPublicacion;
	    }
}
