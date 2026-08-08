import java.util.ArrayList;
public class SystemManager{
    private static String adminPass = "Password123456";
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
            if(o.getDate().equals(date) && o.getSubject().equals(subject) && s >= o.getStart() && s < o.getEnd()){
                results.add(o);
            }
        }

        return results;
    }

    public static Opening getOpen(int ID){
        for(Opening o : allOpenings){
            if(o.getID() == ID){
                return o;
            }
        }
        return null;
    }

    public static void save(){
        FileManager.saveData(allStudents, allTutors, allOpenings);
    }

    public static void load(){
        FileManager.loadData();
    }
    public static void setAllStudents(ArrayList<Student> studentList){
        allStudents = studentList;
    }

    public static void setAllTutors(ArrayList<Tutor> tutorList){
        allTutors = tutorList;
    }

    public static void setAllOpenings(ArrayList<Opening> openingList){
        allOpenings = openingList;
    }

    public static String getAdminPass(){
        return adminPass;
    }

    public static Tutor verifyTutor(String name, String password){
        for(Tutor t : allTutors){
            if(t.getName().equals(name) && t.getPassword().equals(password)){
                return t;
            }
        }
        return null;
    }

    public static Student verifyStudent(String name, String password){
        for(Student s : allStudents){
            if(s.getName().equals(name) && s.getPassword().equals(password)){
                return s;
            }
        }
        return null;
    }
}
