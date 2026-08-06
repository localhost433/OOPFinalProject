import java.util.ArrayList;
public class Student{
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

    public void addBooking(Opening o){
        bookedOpenings.add(o);
    }
}
