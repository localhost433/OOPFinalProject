import java.io.Serializable;
public class Opening implements Serializable{
    private static int nextID = 1;

    private int id;

    private int start;
    private int end;
    private String date;
    private Tutor openingTutor;
    private String subject;
    private Student openingStudent;
    private int id;

    public Opening(int s, int e, String d, Tutor t){
        id = nextID++;
        start = s;
        end = e;
        date = d;
        openingTutor = t;
        subject = t.getSubject();
        openingStudent = null;
    }

    public int getStart(){
        return start;
    }

    public int getEnd(){
        return end;
    }

    public String getSubject(){
        return subject;
    }

    public String getDate(){
        return date;
    }

    public void setStudent(Student s){
        openingStudent = s;
    }

    public int getID(){
        return id;
    }

    public boolean isAvailable(){
        return false;
    }

    public int getID(){
        return id;
    }

    public boolean isAvailable(){
        return (openingStudent==null);
    }

    public String toString() {
        if (openingStudent == null) {
            return id + " | " + date + " | " + start + "-" + end + " | " + subject + " | Tutor: " + openingTutor.getName() + " | Status: Available";
        }
        return id + " | " + date + " | " + start + "-" + end + " | " + subject + " | Tutor: " + openingTutor.getName() + " | Status: Booked by " + openingStudent.getName();
    }
}
