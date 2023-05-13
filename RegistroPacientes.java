import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;

public class RegistroPacientes { //Asdruds

    private List<Paciente> pacientes;
    private int idP = 1;
    String archivo = "Pacientes.csv";
    Scanner scanner = new Scanner(System.in);

    public RegistroPacientes(){
        this.pacientes = new ArrayList<>();
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void registrarPaciente(){

        System.out.print("Nombre del paciente:");
        String nombre = scanner.nextLine();

        System.out.print("Edad del paciente:");
        String edad = scanner.nextLine();

        System.out.print("Teléfono de contacto del paciente:");
        String numT = scanner.nextLine();

        Paciente paciente = new Paciente(nombre, edad, numT, idP);

        idP++;

        pacientes.add(paciente);
        System.out.println("Paciente registrado.");

    }

    public void mostrarListaPacientes() {
        if (pacientes.isEmpty()) {
            System.out.println("No hay pacientes registrados.");
        } else {
            System.out.println("Lista de pacientes:");
            for (int i = 0; i < pacientes.size(); i++) {
                System.out.println((i + 1) + ". " + pacientes.get(i).nombrePaciente);
            }
        }
    }

    public void archivoPaciente() throws IOException{

        BufferedWriter writer = new BufferedWriter(new FileWriter(archivo));

        writer.write("Nombre , Edad, Teléfono, ID");
        writer.newLine();

        for(Paciente paciente : pacientes){

            String linea = paciente.nombrePaciente + "," + paciente.getEdad() + "," + paciente.getNum() + "," + paciente.getID();
            writer.write(linea);
            writer.newLine();

        }
        writer.close();
        System.out.println("Archivo de pacientes creado exitosamente.");

    }

    public void DatosExtras(){

        Paciente paciente = new Paciente("Axel León","23" ,"5587652104" , idP);
        idP++;
        pacientes.add(paciente);

        Paciente paciente1 = new Paciente("Fransisco Marín","68" ,"5533221144" , idP);
        idP++;
        pacientes.add(paciente1);

        Paciente paciente2 = new Paciente("Iván Gutierrez","31" ,"5503265948" , idP);
        idP++;
        pacientes.add(paciente2);

        Paciente paciente3 = new Paciente("Ximena Ylescas","19" ,"5573198246" , idP);
        idP++;
        pacientes.add(paciente3);

    }

}
