<<<<<<< HEAD
import java.io.*;
import java.util.ArrayList;
public class FileManager{
    private static String fileName = "system_data.bin";

    public static void saveData(ArrayList<Student> students, ArrayList<Tutor> tutors, ArrayList<Opening> openings){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(students);
            oos.writeObject(tutors);
            oos.writeObject(openings);
        } 
        catch (Exception e) {
            
        }
    }

    public static void loadData(){
        File file = new File(fileName);
        
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            ArrayList<Student> students = (ArrayList<Student>) ois.readObject();
            ArrayList<Tutor> tutors = (ArrayList<Tutor>) ois.readObject();
            ArrayList<Opening> openings = (ArrayList<Opening>) ois.readObject();

            SystemManager.setAllStudents(students);
            SystemManager.setAllTutors(tutors);
            SystemManager.setAllOpenings(openings);

        } 
        catch (Exception e) {

        }
=======
public class FileManager{
    public static void saveData(){

>>>>>>> b475c9a6846505953beb182a60d40c49c03acdec
    }
}
