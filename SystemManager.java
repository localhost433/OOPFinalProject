import java.util.ArrayList;
public class SystemManager{
    private static ArrayList<Opening> allOpenings = new ArrayList<>();
    private static ArrayList<Tutor> allTutors = new ArrayList<>();
    private static ArrayList<Student> allStudents = new ArrayList<>();
    private static String adminPassword = "Password123456";

    public static String getAdminPassword(){
        return adminPassword;
    }

    public static ArrayList<Student> getAllStudents(){
        return allStudents;
    }

    public static ArrayList<Tutor> getAllTutors(){
        return allTutors;
    }

    public static ArrayList<Opening> getAllOpenings(){
        return allOpenings;
    }

    public static ArrayList<Opening> search(int time, String subject, String date){
        ArrayList<Opening> results = new ArrayList<>();

        for(Opening o : allOpenings){
            if((o.getTutor().getSubject() == subject && (time < o.getEnd() && time >= o.getstart())) && o.getDate() == date){
                results.add(o);
            }
        }
        
        return results;
    }
}
