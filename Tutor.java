import java.util.ArrayList;
import java.io.Serializable;
public class Tutor implements Serializable{
    private ArrayList<Opening> AvailableOpenings = new ArrayList<>();
    private String name;
    private String password;
    private String subject;

    public Tutor(String n, String p, String s){
        name = n;
        password = p;
        subject = s;
    }

    public void addOpening(Opening o){
        AvailableOpenings.add(o);
    }

    public String getSubject(){
        return subject;
    }

    public ArrayList<Opening> getAllOpenings(){
        return AvailableOpenings;
    }

    public String getName(){
        return name;
    }

    public String getPassword(){
        return password;
    }

    public boolean hasConflict(Opening newOpening){
        for(Opening o : AvailableOpenings){

            if(o.getDate().equals(newOpening.getDate()) &&
            newOpening.getStart() < o.getEnd() &&
            newOpening.getEnd() > o.getStart()){

                return true;
            }
        }

        return false;
    }
}
