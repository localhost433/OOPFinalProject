import java.util.ArrayList;
import java.io.Serializable;
public class Student implements Serializable{
    private static final long serialVersionUID = 1L;

    private ArrayList<Opening> bookedOpenings = new ArrayList<>();
    private String name;
    private String password;

    public Student(String n, String p){
        name = n;
        password = p;
    }

    public ArrayList<Opening> getAllBookings(){
        return bookedOpenings;
    }

    public void addOpening(Opening o){
        bookedOpenings.add(o);
    }

    public void removeBooking(int ID){
        for(int i = 0; i < bookedOpenings.size(); i++){
            if(bookedOpenings.get(i).getID() == ID){
                bookedOpenings.remove(i);
                return;
            }
        }
    }

    public String getName(){
        return name;
    }

    public String getPassword(){
        return password;
    }

    public boolean hasConflict(Opening newOpening){
        for(Opening o : bookedOpenings){

            if(o.getDate().equals(newOpening.getDate()) &&
            newOpening.getStart() < o.getEnd() &&
            newOpening.getEnd() > o.getStart()){

                return true;
            }
        }

        return false;
    }

    public boolean checkBookings(int ID){
        for(Opening open : bookedOpenings){
            if(open.getID() == ID){
                return true;
            }
        }
        return false;
    }
}
