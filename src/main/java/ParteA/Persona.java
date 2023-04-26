package ParteA;

import java.util.regex.Pattern;
import java.util.Scanner;

public class Persona {
    private String nombre;
    private String apellidos;
    private String nif;
    private String contrasena;

    public Persona(String nombre, String apellidos, String nif, String contrasena) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nif = nif;

        boolean contrasenaValida = false;
        do {
            if (contrasenaValida(contrasena)) {
                this.contrasena = contrasena;
                contrasenaValida = true;
            } else {
                System.out.println("La contraseña debe tener al menos 8 caracteres. Inténtalo de nuevo:");
                contrasena = pedirContrasena();
            }
        } while (!contrasenaValida);
    }

    public Persona(Persona otraPersona) {
        this.nombre = otraPersona.nombre;
        this.apellidos = otraPersona.apellidos;
        this.nif = otraPersona.nif;
        this.contrasena = otraPersona.contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getContrasena() {
        return contrasena;
    }

    private boolean contrasenaValida(String contrasena) {
        String regex = ".{8,}";
        return Pattern.matches(regex, contrasena);
    }

    private String pedirContrasena() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\n" +
                "Apellidos: " + apellidos + "\n" +
                "NIF: " + nif + "\n";
    }

}
