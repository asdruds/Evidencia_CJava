import java.util.Scanner;
import java.util.HashMap;

public class Usuario {

    private String usuario;
    private String contraseña;
    private HashMap<String, String> RegistroUsuario = new HashMap<String, String>();
    Scanner scanner = new Scanner(System.in);
    public Usuario() { }

    public void registrarUsuario() {

        System.out.print("Crea tu usuario: ");
        String user = scanner.nextLine();

        System.out.print("Crea tu contraseña: ");
        String password = scanner.nextLine();

        if(password.length() < 8) {

            while (password.length() < 8) {
                System.out.println("La contraseña debe ser de almenos 8 caracteres.");
                System.out.print("Ingresa tu contraseña: ");
                password = scanner.nextLine();
            }
        }
        RegistroUsuario.put(user, password);
        System.out.println("Registro exitoso.");


    }

    public boolean verificar(String user, String password) {

        if (RegistroUsuario.containsKey(user) && RegistroUsuario.get(user).equals(password)) {
            return true;
        }
        return false;

    }

    public void iniciar_sesion() {

        int intentos = 0;
        boolean inicio = false;

        System.out.print("Ingresa tu usuario: ");
        String usuario = scanner.nextLine();

        System.out.print("Ingresa tu contraseña: ");
        String contraseña = scanner.nextLine();

        inicio = verificar(usuario, contraseña);

        if (inicio == false) {
            do {
                System.out.println("Usuario o contraseña incorrecta, vuelve a ingresar los datos.");
                System.out.print("Usuario: ");
                String usuario1 = scanner.nextLine();
                System.out.print("Contraseña: ");
                String contraseña1 = scanner.nextLine();
                inicio = verificar(usuario1, contraseña1);
                intentos++;
            } while (intentos < 3 && inicio == false);

            if (intentos == 3) {
                System.out.println("Intentos permitidos alcanzados, intentalo más tarde :)");
                System.exit(0);
            }
        }

        System.out.println("BIENVENIDO");

    }

    public void DatosExtras(){

        RegistroUsuario.put("Asdru01", "Asd123");
        RegistroUsuario.put("Maestra", "Evidencia");
        RegistroUsuario.put("Prueba", "prueba");

    }

}
