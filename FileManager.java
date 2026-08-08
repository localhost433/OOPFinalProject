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
        catch (IOException e) {
            System.out.println("Could not save data: " + e);
        }
    }

    public static void loadData(){
        File file = new File(fileName);

        if(!file.exists()){
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            ArrayList<Student> students = (ArrayList<Student>) ois.readObject();
            ArrayList<Tutor> tutors = (ArrayList<Tutor>) ois.readObject();
            ArrayList<Opening> openings = (ArrayList<Opening>) ois.readObject();

            SystemManager.setAllStudents(students);
            SystemManager.setAllTutors(tutors);
            SystemManager.setAllOpenings(openings);

            int maxID = 0;

            for(Opening o : openings){
                if(o.getID() > maxID){
                    maxID = o.getID();
                }
            }

            Opening.setNextID(maxID + 1);
        }
        catch (IOException | ClassNotFoundException e) {
            System.out.println("Could not load saved data: " + e);
        }
    }
}
