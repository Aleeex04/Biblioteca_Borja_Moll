package ParteA;

import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
    static ArrayList<Libro> listaLibros = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static int contadorLibros = 0;

    public static void main(String[] args) {
        int opcion;

        do {
            System.out.println("---------- MENÚ ----------");
            System.out.println("1. Gestión de libros");
            System.out.println("2. Gestión de personal");
            System.out.println("3. Gestión de reservas");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    menuGestionLibros();
                    break;
                case 2:
                    menuGestionPersonal();
                    break;
                case 3:
                    menuGestionReservas();
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 0);
    }

    public static void menuGestionLibros() {
        int opcion;

        do {
            System.out.println("\n---------- GESTIÓN DE LIBROS ----------");
            System.out.println("1. Añadir libro");
            System.out.println("2. Eliminar libro");
            System.out.println("3. Buscar libro por ISBN");
            System.out.println("4. Buscar libro por título");
            System.out.println("5. Ver todos los libros de la biblioteca");
            System.out.println("6. Ver solo los libros disponibles de la biblioteca");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    añadirLibro(listaLibros);
                    break;
                case 2:
                    eliminarLibro(listaLibros);
                    break;
                case 3:
                    buscarLibroPorISBN(listaLibros);
                    break;
                case 4:
                    buscarLibroPorTitulo(listaLibros);
                    break;
                case 5:
                    mostrarTodosLosLibros(listaLibros);
                    break;
                case 6:
                    mostrarLibrosDisponibles(listaLibros);
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 0);
    }

    public static void añadirLibro(ArrayList<Libro> lista) {
        sc.nextLine(); // Limpiar el buffer del scanner

        System.out.println("\nIntroduzca los datos del libro:");
        System.out.print("ISBN: ");
        String isbn = sc.nextLine();
        System.out.print("Título: ");
        String titulo = sc.nextLine();
        System.out.print("Autor: ");
        String autor = sc.nextLine();
        System.out.print("Editorial: ");
        String editorial = sc.nextLine();
        System.out.print("Número de copias: ");
        int numCopias = sc.nextInt();
        System.out.print("Cantidad de libros disponibles: ");
        int numCopiasDisponibles = sc.nextInt();

        if (numCopias < 1 || numCopiasDisponibles < 0 || numCopiasDisponibles > numCopias) {
            System.out.println("Los datos introducidos no son válidos.");
            return;
        }

        Libro libro = new Libro(isbn, titulo, autor, editorial, numCopias, numCopiasDisponibles);
        lista.add(libro);
        contadorLibros++;
        System.out.println("Libro añadido correctamente.");
    }


    public static void eliminarLibro(ArrayList<Libro> lista) {
        sc.nextLine(); // Limpiar el buffer del scanner
        System.out.println("\nIntroduzca el ISBN del libro que desea eliminar:");
        String isbn = sc.nextLine();

        boolean encontrado = false;
        for (Libro libro : lista) {
            if (libro.getISBN().equals(isbn)) {
                encontrado = true;
                if (libro.getNumCopiasDisponibles() == libro.getNumCopias()) {
                    lista.remove(libro);
                    contadorLibros--;
                    System.out.println("Libro eliminado correctamente.");
                } else {
                    System.out.println("No se puede eliminar el libro porque hay copias prestadas.");
                }
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Libro no encontrado.");
        }
    }

    public static void buscarLibroPorISBN(ArrayList<Libro> lista) {
        sc.nextLine(); // Limpiar el buffer del scanner

        System.out.println("\nIntroduzca el ISBN del libro que desea buscar:");
        String isbn = sc.nextLine();

        boolean encontrado = false;
        for (Libro libro : lista) {
            if (libro.getISBN().equals(isbn)) {
                encontrado = true;
                System.out.println(libro.toString());
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Libro no encontrado.");
        }
    }

    public static void buscarLibroPorTitulo(ArrayList<Libro> lista) {
        sc.nextLine(); // Limpiar el buffer del scanner

        System.out.println("\nIntroduzca el título del libro que desea buscar:");
        String titulo = sc.nextLine();

        boolean encontrado = false;
        for (Libro libro : lista) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                encontrado = true;
                System.out.println(libro.toString());
            }
        }

        if (!encontrado) {
            System.out.println("Libro no encontrado.");
        }
    }

    public static void mostrarTodosLosLibros(ArrayList<Libro> lista) {
        System.out.println("\nTodos los libros:");

        if (lista.isEmpty()) {
            System.out.println("No hay libros en la biblioteca.");
            return;
        }

        for (Libro libro : lista) {
            System.out.println(libro.toString());
        }
    }

    public static void mostrarLibrosDisponibles(ArrayList<Libro> lista) {
        System.out.println("\nLibros disponibles:");

        if (lista.isEmpty()) {
            System.out.println("No hay libros en la biblioteca.");
            return;
        }

        for (Libro libro : lista) {
            if (libro.getNumCopiasDisponibles() > 0) {
                System.out.println(libro.toString());
            }
        }
    }




    public static void menuGestionReservas() {
        // Implementar gestión de reservas
    }




    public static ArrayList<Persona> bibliotecariosActivos = new ArrayList<>();
    public static ArrayList<Persona> bibliotecariosInactivos = new ArrayList<>();

    public static void añadirBibliotecario() {
        sc.nextLine(); // Limpiar el buffer del scanner

        System.out.println("\nIntroduzca los datos del bibliotecario:");
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Apellidos: ");
        String apellidos = sc.nextLine();
        System.out.print("NIF: ");
        String nif = sc.nextLine();
        System.out.print("Contraseña: ");
        String contraseña = sc.nextLine();

        Persona bibliotecario = new Persona(nombre, apellidos, nif, contraseña);
        bibliotecariosActivos.add(bibliotecario);
        System.out.println("Bibliotecario añadido correctamente.");
    }

    public static void eliminarBibliotecario() {
        sc.nextLine(); // Limpiar el buffer del scanner

        System.out.print("Introduzca el NIF del bibliotecario que desea eliminar: ");
        String nif = sc.nextLine();

        for (int i = 0; i < bibliotecariosActivos.size(); i++) {
            if (bibliotecariosActivos.get(i).getNif().equals(nif)) {
                bibliotecariosInactivos.add(bibliotecariosActivos.get(i));
                bibliotecariosActivos.remove(i);
                System.out.println("Bibliotecario eliminado correctamente.");
                return;
            }
        }

        System.out.println("No se ha encontrado ningún bibliotecario con el NIF especificado.");
    }


    public static void buscarPersonalPorNIF() {
        sc.nextLine(); // Limpiar el buffer del scanner

        System.out.print("Introduzca el NIF del personal que desea buscar: ");
        String nif = sc.nextLine();

        for (Persona personal : bibliotecariosActivos) {
            if (personal.getNif().equals(nif)) {
                System.out.println("Personal encontrado:");
                System.out.println(personal.toString()); // Mostrar toda la información de la persona encontrada
                return;
            }
        }

        System.out.println("No se ha encontrado ningún personal con el NIF especificado.");
    }

    public static void buscarPersonalPorNombre() {
        sc.nextLine(); // Limpiar el buffer del scanner

        System.out.print("Introduzca el nombre del personal que desea buscar: ");
        String nombre = sc.nextLine();

        for (Persona personal : bibliotecariosActivos) {
            if (personal.getNombre().equals(nombre)) {
                System.out.println("Personal encontrado:");
                System.out.println(personal.toString()); // Mostrar toda la información de la persona encontrada
                return;
            }
        }

        System.out.println("No se ha encontrado ningún personal con el nombre especificado.");
    }

    public static void menuGestionPersonal() {
        int opcion;

        do {
            System.out.println("\n---------- GESTIÓN DE PERSONAL ----------");
            System.out.println("1. Añadir personal");
            System.out.println("2. Eliminar personal");
            System.out.println("3. Buscar personal por NIF");
            System.out.println("4. Buscar personal por nombre");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    añadirBibliotecario();
                    break;
                case 2:
                    eliminarBibliotecario();
                    break;
                case 3:
                    buscarPersonalPorNIF();
                    break;
                case 4:
                    buscarPersonalPorNombre();
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 0);
    }
}
