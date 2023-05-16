package examen2023;

import java.time.LocalDate;
import java.util.Arrays;

public class Biblioteca {
	private MaterialBibliografico[] materiales;
	private int numMateriales;
	private Usuario[] usuarios;
	private int numUsuarios;

	public Biblioteca(int tamMax) {
		this.materiales = new MaterialBibliografico[tamMax];
		this.numMateriales = 0;
		this.usuarios = new Usuario[tamMax];
		this.numUsuarios = 0;
	}

	public MaterialBibliografico[] getMateriales() {
		return materiales;
	}

	public int getNumMateriales() {
		return numMateriales;
	}

	public Usuario[] getUsuarios() {
		return usuarios;
	}

	public int getNumUsuarios() {
		return numUsuarios;
	}

	public void agregarUsuario(Usuario usuario) {
		usuarios[numUsuarios] = usuario;
		numUsuarios++;
	}

	public boolean addMaterial(MaterialBibliografico m) {
		boolean anyadido = false;
		if (numMateriales < materiales.length) {
			materiales[numMateriales++] = m;
			anyadido = true;
		}
		return anyadido;
	}

	public String toString() {
		String cadBiblio = "";
		for (int i = 0; i < numMateriales; i++) {
			cadBiblio += "\n" + materiales[i].toString();
		}
		return cadBiblio;
	}

	// a)
	/*
	 * que devuelve una tabla de objetos de la clase MaterialBibliografico con todos
	 * materiales ordenados. El tamaño de la tabla debe ser el del número de
	 * materiales que contenga. El orden natural de los objetos
	 * MaterialBibliografico es por año de publicación de manera descendente (los
	 * años más actuales van primero, y al final, los más antiguos). A igualdad de
	 * año, se ordenan ascendentemente por titulo. Crea el método que corresponda
	 * para implementar esta ordenación.
	 */
	//Se que si tienen el mismo año no se ordenan por el titulo, no me acuerdo bien como hacerlo
	public MaterialBibliografico[] getMaterialesOrdenados() {
		MaterialBibliografico[] ordenados = Arrays.copyOf(materiales, numMateriales);
		Arrays.sort(ordenados);
		return ordenados;
	}

	// b)
	/*
	 * que busca dicho usuario entre los de la biblioteca, y le agrega el préstamo
	 * recibido como parámetro a sus préstamos. Si el material o el usuario no están
	 * registrados en la biblioteca, o el material está marcado como prestado en los
	 * materiales de la biblioteca, el préstamo no debe incluirse. Devuelve true o
	 * false dependiendo de si el préstamo ha sido registrado o no. Se considera un
	 * material igual que otro si su título, autor y año de publicación son iguales.
	 * Se considera un usuario igual que otro si su número de identificación es
	 * igual. Cabo suelto: Nótese que no estamos actualizando el campo prestado del
	 * material cuando el préstamo se realiza. Ya lo haremos en el método del
	 * apartado d).
	 * 
	 */
	public boolean agregarPrestamo(Prestamo prestamo, Usuario usuario) {
		boolean seHaAgregado = false;
		for (int i = 0; i < numUsuarios; i++) {
			for (int j = 0; j < numMateriales; j++) {
				if (usuarios[i].equals(usuario) && prestamo.getMaterialBibliografico().equals(materiales[j])
						&& materiales[j].estaPrestado() == false) {
					usuarios[i].agregarPrestamo(prestamo);
					seHaAgregado = true;
				}
			}
		}
		return seHaAgregado;

	}
	//Este no esta bien del todo, lo subire a GITHUB

	// c)
	/*
	 * Método que marca el material como devuelto tanto en los materiales de la
	 * biblioteca como en los materiales de los préstamos de los usuarios de la
	 * biblioteca, e indica la fecha de devolución en sus préstamos.
	 */
	// Les estoy dando fecha de devolucion a todos
	public void devolver(MaterialBibliografico mat, LocalDate fechaDev) {
		for (int i = 0; i < numUsuarios; i++) {
			for (int j = 0; j < usuarios[i].getNumPrestamos(); j++) {
				for (int z = 0; z < numMateriales; z++) {
					if (materiales[z].equals(usuarios[i].getPrestamos()[j].getMaterialBibliografico())) {
						materiales[z].devolver();
						usuarios[i].getPrestamos()[j].devolver(fechaDev);
					}
				}
			}
		}

	}

	// d)
	/*
	 * Actualiza el campo prestado del material bibliográfico de la biblioteca
	 * teniendo en cuenta los préstamos de los usuarios. Si, para un material, hay
	 * algún préstamo de alguno de los usuarios cuya fecha de devolución sea nula,
	 * quiere decir que está prestado, y si no hay préstamos, o los que hay, tienen
	 * fecha de devolución, es que ese material no está prestado.
	 */
	public void actualizaMaterialesPrestados() {
		for (int i = 0; i < numMateriales; i++) {
			for (int j = 0; j < numUsuarios; j++) {
				for (int z = 0; z < usuarios[j].getNumPrestamos(); z++) {
					if (materiales[i].equals(usuarios[j].getPrestamos()[z].getMaterialBibliografico())
							&& usuarios[j].getPrestamos()[z].getFechaDevolucion() == null) {
						materiales[i].prestar();
					}
				}
			}
		}

	}

	// e)
	/*
	 * Devuelve un array -del tamaño justo- con los préstamos asociados al material
	 * que se pasa como parámetro.
	 */
	public Prestamo[] prestamosDeMaterial(MaterialBibliografico material) {
		int numPrestamosRes = 0;
		Prestamo[] prestamos = new Prestamo[numPrestamosRes + 1];
		for (int i = 0; i < numUsuarios; i++) {
			for (int j = 0; j < usuarios[i].getNumPrestamos(); j++) {
				if (material.equals(usuarios[i].getPrestamos()[j].getMaterialBibliografico())) {
					prestamos[numPrestamosRes] = usuarios[i].getPrestamos()[j];
					numPrestamosRes++;
					prestamos = Arrays.copyOf(prestamos, numPrestamosRes + 1);

				}
			}
		}
		prestamos = Arrays.copyOf(prestamos, numPrestamosRes);
		return prestamos;
	}

}
