import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Menu { //Asdruds

    public Menu(){
    }

    public void MostrarMenu() throws IOException {

        Scanner scanner = new Scanner(System.in);
        Usuario user = new Usuario();
        RegistroPacientes ListaPacientes = new RegistroPacientes();
        RegistroDoctores ListaDoctores = new RegistroDoctores();
        Cita cita = new Cita();

        //Datos de relleno
        user.DatosExtras();
        ListaDoctores.DatosExtras();
        ListaPacientes.DatosExtras();


        System.out.println("Bienvenido. \n A) Iniciar Sesión\n B) Registrarse en el sistema");
        String opcion = scanner.next();

        if(!opcion.equals("A") && !opcion.equals("B")) {

            while (!opcion.equals("A") && !opcion.equals("B")) {

                System.out.println("Opción no válida, vuelve a ingresar:");
                opcion = scanner.next();

            }
        }
        if (opcion.equals("A")) {
            user.iniciar_sesion();
        } else if (opcion.equals("B")) {
            user.registrarUsuario();
        }


        System.out.println("Que deseas realizar. \n A) Dar de alta paciente\n B) Dar de alta doctor\n C) Agendar una cita\n D) Generar archivo\n E) Salir");
        String opcion1 = scanner.next();

        do {

            switch (opcion1) {

                case "a":
                case "A":

                    ListaPacientes.registrarPaciente();
                    break;

                case "b":
                case "B":

                    ListaDoctores.registrarDoctor();
                    break;

                case "c":
                case "C":

                    ListaPacientes.mostrarListaPacientes();
                    List<Paciente> pacientes = ListaPacientes.getPacientes();

                    System.out.print("Seleccione el número del paciente: ");
                    int numP = scanner.nextInt();
                    Paciente Pac = pacientes.get(numP - 1);

                    ListaDoctores.mostrarListaDoctores();
                    List<Doctor> doctores = ListaDoctores.getDoctores();

                    System.out.print("Seleccione el número del doctor: ");
                    int numD = scanner.nextInt();
                    Doctor Doc = doctores.get(numD - 1);

                    cita.crearCita(Doc,Pac);
                    break;

                case "d":
                case "D":

                    try {
                        ListaPacientes.archivoPaciente();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    try {
                        ListaDoctores.archivoDoctor();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;

                default:
                    System.out.println("Opción no valida");
                    break;
            }

            System.out.println("Que deseas realizar. \n A) Dar de alta paciente\n B) Dar de alta doctor\n C) Agendar una cita\n D) Generar archivo\n E) Salir");
            opcion1 = scanner.next();

        } while (!opcion1.equals("e") && !opcion1.equals("E"));

        System.out.println("Hasta luego :)");

    }

}
