package examen2023;

import java.time.LocalDate;

public class Prestamo {
	private MaterialBibliografico materialBibliografico;
	private LocalDate fechaPrestamo;
	private LocalDate fechaDevolucion;

	public Prestamo(MaterialBibliografico materialBibliografico, LocalDate fechaPrestamo) {
		this.materialBibliografico = materialBibliografico;
		this.fechaPrestamo = fechaPrestamo;
		this.fechaDevolucion = null;
	}

	public MaterialBibliografico getMaterialBibliografico() {
		return materialBibliografico;
	}

	public void setMaterialBibliografico(MaterialBibliografico materialBibliografico) {
		this.materialBibliografico = materialBibliografico;
	}

	public LocalDate getFechaPrestamo() {
		return fechaPrestamo;
	}

	public void setFechaPrestamo(LocalDate fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}

	public LocalDate getFechaDevolucion() {
		return fechaDevolucion;
	}

	public void setFechaDevolucion(LocalDate fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}

	public boolean estaPrestado() {
		return (fechaDevolucion == null);
	}

	public void devolver(LocalDate fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
		materialBibliografico.devolver();
	}

	@Override
	public String toString() {
		return "Prestamo [materialBibliografico=" + materialBibliografico + ", fechaPrestamo=" + fechaPrestamo
				+ ", fechaDevolucion=" + fechaDevolucion + "]";
	}
}
