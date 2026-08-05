public class Opening{
    private int start;
    private int end;
    private String date;
    private Tutor openingTutor;
    private Student s;

    public Opening(int s, int e, String d, Tutor t){
        start = s;
        end = e;
        date = d;
        openingTutor = t;
        s = null;
    }

    public Tutor getTutor(){
        return t;
    }

    public int getStart(){
        return start;
    }

    public int getEnd(){
        return end;
    }

    public String getDate(){
        return date;
    }
}
