import java.util.Scanner;

public class Doctor { //Asdruds

    private int id_doctor;
    public String nombreDoctor;
    public String especialidad;
    private String num_telefónico;

    Scanner scanner = new Scanner(System.in);

    public int getID(){
        return id_doctor;
    }
    public String getNum(){
        return num_telefónico;
    }

    public Doctor (String nombreDoctor, String especialidad, String num_telefónico, int id){

        this.nombreDoctor = nombreDoctor;
        this.especialidad = especialidad;
        this.num_telefónico = num_telefónico;
        this.id_doctor = id;

    }

}
