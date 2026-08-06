import java.util.ArrayList;
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        
    }

    public static void createStudent(Sting name, String password){
        Student s = new Student(name, password);
        SystemManager.addStudent(s);
    }

    public static void addTutor(Sting name, String password, String subject){
        Tutor t = new Tutor(name, password, subject);
        SystemManager.addTutor(t);
    }

    public static void addOpening(int s, int e, String d, Tutor t){
        Opening o = new Opening(s, e, d, t);
        t.addOpening(o);
        SystemManager.addOpening(o);
    }

    public static void searchOpenings(int s, String subject, String date){
        ArrayList<Opening> results = SystemManager.searchOpenings(s, subject, date);
        System.out.println(results);
    }

    public static void displayOpeningsForTutor(Tutor t){
        ArrayList<Opening> allOps = t.getAllOpenings();
        System.out.println(allOps);
    }

    public static void displayOpeningsForTutor(Student s){
        ArrayList<Opening> allOps = s.getAllBookings();
        System.out.println(allOps);
    }

    //we need to make methods that allow a student to book and cancel an opening
}
