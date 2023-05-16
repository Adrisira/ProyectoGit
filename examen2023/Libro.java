package examen2023;

public class Libro extends MaterialBibliografico{
	private int numeroPaginas;

	public Libro(String titulo, String autor, int anoPublicacion, int numeroPaginas) {
		super(titulo, autor, anoPublicacion);
		this.numeroPaginas = numeroPaginas;
	}

	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}
	

	public String toString() {
		return super.toString() + "\nNúmero de páginas: " + this.numeroPaginas;
	}
}
