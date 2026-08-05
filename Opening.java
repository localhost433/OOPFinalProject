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
        SystemManager.getAllOpenings().add(this);
    }
}
