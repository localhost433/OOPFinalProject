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
    }

    public String getName(){
        return name;
    }

    public String getPassword(){
        return paswword;
    }

    public ArrayList<Opening> getOpenings(){
        return AvailableOpenings;
    }

    public String getSubject(){
        return subject;
    }
}
