import java.util.ArrayList;
public class Student{
    private ArrayList<Opening> bookedOpenings = new ArrayList<>();
    private String name;
    private String password;

    public Student(String n, String p){
        name = n;
        password = p;
        SystemManager.getAllStudents().add(this);
    }
}
