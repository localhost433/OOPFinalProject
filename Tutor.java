import java.util.ArrayList;
public class Tutor{
    private ArrayList<Opening> AvailableOpenings = new ArrayList<>();
    private String name;
    private String password;
    private String subject;

    public Tutor(String n, String p, String s){
        name = n;
        password = p;
        subject = s;
        SystemManager.getAllTutors().add(this);
    }
}
