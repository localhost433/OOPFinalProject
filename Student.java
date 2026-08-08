import java.util.ArrayList;
import java.io.Serializable;
public class Student implements Serializable{
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

<<<<<<< HEAD
    public void removeBooking(int ID){
        for(Opening o : bookedOpenings){
            if(o.getID() == ID){
                bookedOpenings.remove(o);
            }
        }
    }

    public String getName(){
        return name;
    }

    public String getPassword(){
        return password;
=======
    public Opening getOpen(int ID){
        return null;
    }

    public void removeBooking(Opening o){

>>>>>>> b475c9a6846505953beb182a60d40c49c03acdec
    }
}
