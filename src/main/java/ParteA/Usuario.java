package ParteA;

public class Usuario extends Persona {
    private int numReservas;

    public Usuario(String nombre, String apellidos, String nif, String contrasena) {
        super(nombre, apellidos, nif, contrasena);
        this.numReservas = 0;
    }

    public Usuario(Usuario usuario) {
        super(usuario.getNombre(), usuario.getApellidos(), usuario.getNif(), usuario.getContrasena());
        this.numReservas = usuario.getNumReservas();
    }

    public int getNumReservas() {
        return numReservas;
    }

    public void setNumReservas(int numReservas) {
        this.numReservas = numReservas;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + getNombre() + '\'' +
                ", apellidos='" + getApellidos() + '\'' +
                ", NIF='" + getNif() + '\'' +
                ", contrasena='" + getContrasena() + '\'' +
                ", numReservas=" + numReservas +
                '}';
    }

    public boolean validarContrasena(String contrasena) {
        return contrasena.length() >= 8;
    }

}
