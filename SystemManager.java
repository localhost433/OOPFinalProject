import java.util.ArrayList;
public class SystemManager{
    private static ArrayList<Opening> allOpenings = new ArrayList<>();
    private static ArrayList<Tutor> allTutors = new ArrayList<>();
    private static ArrayList<Student> allStudents = new ArrayList<>();

    public static void addStudent(Student s){
        allStudents.add(s);
    }

    public static void addTutor(Tutor t){
        allTutors.add(t);
    }

    public static void addOpening(Opening o){
        allOpenings.add(o);
    }

    public static ArrayList<Opening> searchOpenings(int s, String subject, String date){
        ArrayList<Opening> results = new ArrayList<>();
        for(Opening o : allOpenings){
            if(o.getDate() == date && o.getSubject() == subject && s >= o.getStart() && s < o.getEnd()){
                results.add(o);
            }
        }

        return results;
    }
}
