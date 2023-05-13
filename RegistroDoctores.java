import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;

public class RegistroDoctores { //Asdruds

    public Doctor doctor;
    private List<Doctor> doctores;
    private int idD = 1;
    String archivo = "Doctores.csv";
    Scanner scanner = new Scanner(System.in);

    public RegistroDoctores(){
        this.doctores = new ArrayList<>();
    }

    public List<Doctor> getDoctores() {
        return doctores;
    }
    public void registrarDoctor(){

        System.out.print("Nombre del Doctor:");
        String nombre = scanner.nextLine();

        System.out.print("Especialidad del paciente:");
        String especialidad = scanner.nextLine();

        System.out.print("Teléfono de contacto del paciente:");
        String numT = scanner.nextLine();

        Doctor doctor = new Doctor(nombre, especialidad, numT, idD);

        idD++;

        doctores.add(doctor);
        System.out.println("Doctor registrado.");

    }

    public void mostrarListaDoctores() {
        if (doctores.isEmpty()) {
            System.out.println("No hay doctores registrados.");
        } else {
            System.out.println("Lista de doctores:");
            for (int i = 0; i < doctores.size(); i++) {
                System.out.println((i + 1) + ". " + doctores.get(i).nombreDoctor);
            }
        }
    }

    public void archivoDoctor() throws IOException{

        BufferedWriter writer = new BufferedWriter(new FileWriter(archivo));

        writer.write("Nombre , Especialidad, Teléfono, ID");
        writer.newLine();

        for(Doctor doctor : doctores){

            String linea = doctor.nombreDoctor + "," + doctor.especialidad + "," + doctor.getNum() + "," + doctor.getID();
            writer.write(linea);
            writer.newLine();

        }
        writer.close();
        System.out.println("Archivo de Doctores creado exitosamente.");

    }

    public void DatosExtras(){

        Doctor doctor = new Doctor("Alma López", "Gastroenterología", "5554320895", idD);
        idD++;
        doctores.add(doctor);

        Doctor doctor1 = new Doctor("Gilberto Sánchez", "Ortopedia", "5532549887", idD);
        idD++;
        doctores.add(doctor1);

        Doctor doctor2 = new Doctor("Diego Morales", "Dermatología", "5501472569", idD);
        idD++;
        doctores.add(doctor2);

        Doctor doctor3 = new Doctor("Diana Garduño", "Cardiología", "5639281746", idD);
        idD++;
        doctores.add(doctor3);

    }

}
