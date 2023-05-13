import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cita { //Asdruds

    public Paciente paciente;
    public Doctor doctor;
    private static List<Cita> citas = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    private int idC;
    private int contID;
    public String fecha;
    public String hora;
    public String motivo;

    public Cita(Paciente paciente, Doctor doctor, String fecha, String hora, String motivo) {
        this.idC = contID++;
        this.paciente = paciente;
        this.doctor = doctor;
        this.fecha = fecha;
        this.hora = hora;
        this.motivo = motivo;
    }
    public Cita(){

    }

    public Cita crearCita(Doctor doctor, Paciente paciente){


        System.out.println(" - Datos de la cita - ");

        System.out.println("Ingresa el dia: DD");
        String dia = scanner.next();

        System.out.println("Ingresa el mes: MM");
        String mes = scanner.next();

        System.out.println("Ingresa el año: AAAA");
        String año = scanner.next();

        String fecha = (dia + " - " + mes +" - " + año);

        System.out.println("Ingresa la hora ( 00:00 ) :");
        String hora = scanner.next();

        System.out.println("Ingresa el motivo: ");
        String motivo = scanner.next();

        if (verificarCitaExistente(doctor, fecha, hora)) {
            System.out.println("Ya existe una cita para este doctor en la misma fecha y hora.");
            return null;
        }

        Cita nuevaCita = new Cita(paciente, doctor, fecha, hora, motivo);
        citas.add(nuevaCita);

        System.out.println("La cita ha sido creada.");
        System.out.println("Datos de la cita:");
        System.out.println("Doctor: " + nuevaCita.doctor.nombreDoctor + " | Paciente: " + nuevaCita.paciente.nombrePaciente);
        System.out.println("Fecha: " + nuevaCita.fecha + " | Hora: " + nuevaCita.hora);

        return nuevaCita;

    }
    public boolean verificarCitaExistente(Doctor doctor, String fecha, String hora) {
        for (Cita citaExistente : citas) {
            if (citaExistente.doctor.equals(doctor) && citaExistente.fecha.equals(fecha) && citaExistente.hora.equals(hora)) {
                return true;
            }
        }
        return false;
    }

}