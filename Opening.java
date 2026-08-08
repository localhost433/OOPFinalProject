public class Opening{
    private int start;
    private int end;
    private String date;
    private Tutor openingTutor;
    private String subject;
    private Student openingStudent;
    private int id;

    public Opening(int s, int e, String d, Tutor t){
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
}
