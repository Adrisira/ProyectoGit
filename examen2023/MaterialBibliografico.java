package examen2023;

import java.util.Objects;

public class MaterialBibliografico implements Comparable<MaterialBibliografico> {
	protected String titulo;
	protected String autor;
	protected int anoPublicacion;
	protected boolean prestado;

	public MaterialBibliografico(String titulo, String autor, int anoPublicacion) {
		this.titulo = titulo;
		this.autor = autor;
		this.anoPublicacion = anoPublicacion;
		this.prestado = false;
	}

	public MaterialBibliografico(String titulo, int anoPublicacion) {
		this.titulo = titulo;
		this.autor = "-";
		this.anoPublicacion = anoPublicacion;
		this.prestado = false;
	}

	public boolean prestar() {
		boolean puedePrestarse = !estaPrestado();
		if (puedePrestarse) {
			this.prestado = true;
		}
		return puedePrestarse;
	}

	public boolean devolver() {
		boolean puedeDevolverse = estaPrestado();

		if (puedeDevolverse) {
			this.prestado = false;
		}
		return puedeDevolverse;
	}

	public boolean estaPrestado() {
		return this.prestado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(anoPublicacion, autor, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MaterialBibliografico other = (MaterialBibliografico) obj;
		return anoPublicacion == other.anoPublicacion && Objects.equals(autor, other.autor)
				&& Objects.equals(titulo, other.titulo);
	}

	public String toString() {
		return ("\n\n* Título: " + this.titulo + "\n" + "Autor: " + this.autor + "\n" + "Año de publicación: "
				+ this.anoPublicacion + " \nprestado: " + prestado);
	}

	@Override
	public int compareTo(MaterialBibliografico o) {
		return o.anoPublicacion - this.anoPublicacion;
	}
}
