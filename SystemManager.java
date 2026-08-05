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
}
