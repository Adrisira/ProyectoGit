package examen2023;

import java.util.Objects;

public class Usuario {
	private String nombre;
	private String apellido;
	private int identificacion;
	private Prestamo[] prestamos;
	private int numPrestamos;

	public Usuario(String nombre, String apellido, int identificacion) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.identificacion = identificacion;
		this.prestamos = new Prestamo[10]; // Inicializamos el array con capacidad para 10 objetos
		this.numPrestamos = 0;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(int identificacion) {
		this.identificacion = identificacion;
	}

	public Prestamo[] getPrestamos() {
		return prestamos;
	}

	public int getNumPrestamos() {
		return numPrestamos;
	}

	// agrega el préstamo
	public boolean agregarPrestamo(Prestamo prestamo) {
		boolean anyadido = false;
		// if (prestamo.getMaterialBibliografico().prestar()) {
		if (numPrestamos < prestamos.length) {
			prestamos[numPrestamos] = prestamo;
			numPrestamos++;
			anyadido = true;
		}
		// }
		return anyadido;
	}

	@Override
	public int hashCode() {
		return Objects.hash(identificacion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return identificacion == other.identificacion;
	}

	public String toString() {
		String cad = identificacion + ":" + nombre + " " + apellido;
		for (int i = 0; i < numPrestamos; i++) {
			cad += "\n\tPrestamo " + (i + 1) + ": " + prestamos[i].getMaterialBibliografico() + " - Fecha de préstamo: "
					+ prestamos[i].getFechaPrestamo() + " - Fecha de devolución: " + prestamos[i].getFechaDevolucion();
		}
		return cad;
	}
}
