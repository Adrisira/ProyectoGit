package examen2023;

public class Revista extends MaterialBibliografico{
	private int numero;

	public Revista(String titulo, String autor, int anoPublicacion, int numero) {
		super(titulo, autor, anoPublicacion);
		this.numero = numero;
	}

	public Revista(String titulo, int anoPublicacion, int numero) {
		super(titulo, anoPublicacion);
		this.numero = numero;
	}

	public String toString() {
		return super.toString() + "\nNúmero: " + this.numero;
	}
}
