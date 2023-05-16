package examen2023;

import java.time.LocalDate;
import java.util.Arrays;

public class BibliotecaPrincipal {
	 public static void main(String[] args) {
	        Biblioteca biblioteca = new Biblioteca(50);
		     
	        // Crear algunos materiales bibliográficos
	        Libro libro1 = new Libro("Harry Potter y la piedra filosofal", "J.K. Rowling", 1997, 223);
	        Libro libro2 = new Libro("La Iliada", "Homero", 1980, 800);
	        Libro libro3 = new Libro("El Código Da Vinci", "Dan Brown", 2003, 500);
	        Libro libro4 = new Libro("El Quijote", "Miguel de Cervantes", 1605, 863);
	        
	        Revista revista1 = new Revista("National Geographic", 2021, 10);
	        Revista revista2 = new Revista("Vanity Fair", "Condé Nast", 2022, 80);
	        Revista revista3 = new Revista("Time", "Time Inc.", 2022, 70);
	        Revista revista4 = new Revista("National Geographic I", "Sociedad Geográfica Nacional", 1888, 150);

	        Periodico periodico1 = new Periodico("El País", "Grupo Prisa", 1976, "1 de octubre de 1976");
	        Periodico periodico2 = new Periodico("The New York Times", "The New York Times Company", 2022, "15 de marzo de 2022");
	        Periodico periodico3 = new Periodico("The Guardian", "Guardian News & Media", 2022, "16 de marzo de 2022");
	        
	        biblioteca.addMaterial(libro1);
	        biblioteca.addMaterial(libro4);
	        biblioteca.addMaterial(revista4);
	        biblioteca.addMaterial(periodico1);
	        biblioteca.addMaterial(libro2);
	        biblioteca.addMaterial(libro3);
	        biblioteca.addMaterial(revista2);
	        biblioteca.addMaterial(periodico2);
	       // biblioteca.addMaterial(periodico3);
	        //biblioteca.addMaterial(revista3);
	        biblioteca.addMaterial(revista1);
	        
	        // Crear algunos préstamos
	        Prestamo prestamo1 = new Prestamo(libro1, LocalDate.of(2022, 1, 1));
	        Prestamo prestamo2 = new Prestamo(revista1, LocalDate.of(2022, 2, 1));
	        Prestamo prestamo3 = new Prestamo(periodico1, LocalDate.of(2022, 3, 1));

	        // Crear un usuario y agregar algunos préstamos si es que es posible porque no estén ya prestados
	        //dichos materiales
	        Usuario usuario1 = new Usuario("Juan", "Pérez", 1);
	        biblioteca.agregarUsuario(usuario1);

	        // Crear más préstamos y agregarlos a otro usuario si es que es posible porque no estén ya prestados
	        //dichos materiales
	        Prestamo prestamo4 = new Prestamo(revista3, LocalDate.of(2022, 4, 1));
	        Prestamo prestamo5 = new Prestamo(periodico3, LocalDate.of(2022, 5, 1));
	        Prestamo prestamo6 = new Prestamo(periodico2, LocalDate.of(2022, 5, 1));
	        Prestamo prestamo7 = new Prestamo(periodico3, LocalDate.of(2022, 5, 1));
	        
	        Usuario usuario2 = new Usuario("María", "Gómez", 2);
	        biblioteca.agregarUsuario(usuario2);
	        
	        //usuario no añadido:
	        Usuario usuario3 = new Usuario("Felipe", "Diaz", 3);
	        
	        System.out.println("\n------------------------------------------------");
	        System.out.println("Materiales registrados: " + biblioteca);
	        System.out.println("\nUsuarios registrados: " + Arrays.toString(Arrays.copyOf(biblioteca.getUsuarios(),biblioteca.getNumUsuarios())));
	        
	        System.out.println("\n------------------------------------------------");
	        System.out.println("a) Materiales ordenados: "+ Arrays.toString(biblioteca.getMaterialesOrdenados()));

	        System.out.println("\n------------------------------------------------");
	        System.out.println("b) Agregamos préstamos:" );
	       
	        System.out.println("\tPrestamo 1 (true):"+biblioteca.agregarPrestamo(prestamo1, usuario1));//true
	        System.out.println("\tPrestamo 2 (true):"+biblioteca.agregarPrestamo(prestamo2, usuario1));//true
	        System.out.println("\tPrestamo 3 (true):"+biblioteca.agregarPrestamo(prestamo3, usuario1));//true
	        System.out.println("\tPrestamo 4 (false):"+biblioteca.agregarPrestamo(prestamo4, usuario2));//false por material no registrado
	        System.out.println("\tPrestamo 5 (false):"+biblioteca.agregarPrestamo(prestamo5, usuario2));//false por material no registrado
	        System.out.println("\tPrestamo 6 (true):"+biblioteca.agregarPrestamo(prestamo6, usuario2));//true
	        System.out.println("\tPrestamo 7 (false):"+biblioteca.agregarPrestamo(prestamo7, usuario3));//false por usuario no registrado

	        
	        //c)
	        System.out.println("\n------------------------------------------------");
	        System.out.println("c) Devolvemos el préstamo1 del usuario1: debe tener fecha de devolución");
	        biblioteca.devolver(libro1, LocalDate.of(2023, 3, 1));	
	        //El préstamo1 del usuario1 debe tener fecha de devolución
			System.out.println("\nUsuarios registrados: "
					+ Arrays.toString(Arrays.copyOf(biblioteca.getUsuarios(),biblioteca.getNumUsuarios())));
	        
	        //d)	        
	        System.out.println("\n------------------------------------------------");
	        biblioteca.actualizaMaterialesPrestados();
	        System.out.println("d) Materiales tras devolver Harry Potter y actualizar prestados: " + biblioteca);
	        
	        //e)
	        Prestamo prestamo8 = new Prestamo(libro1, LocalDate.of(2023, 1, 1));
	        biblioteca.agregarPrestamo(prestamo8, usuario2);
	        System.out.println("\n------------------------------------------------");
	        System.out.println("e) Préstamos de un material concreto tras prestar de nuevo Harry Potter: "+ Arrays.toString(biblioteca.prestamosDeMaterial(libro1)));
	        
	        
	        
	        

	    }
}
