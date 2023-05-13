import java.util.Scanner;

public class Paciente { //Asdruds

    private int id_paciente;
    public String nombrePaciente;
    private String edad;
    private String num_telefónico;
    Scanner scanner = new Scanner(System.in);

    public int getID(){
        return id_paciente;
    }
    public String getEdad(){
        return edad;
    }
    public String getNum(){
        return num_telefónico;
    }

    public Paciente (String nombrePaciente, String edad, String num_telefónico, int id){

        this.nombrePaciente = nombrePaciente;
        this.edad = edad;
        this.num_telefónico = num_telefónico;
        this.id_paciente = id;

    }


}
