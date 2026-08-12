import java.util.ArrayList;

public class AppointmentService{

    public void load(){
        SystemManager.load();
    }

    public boolean authenticateAdmin(String password){
        return SystemManager.getAdminPass().equals(password);
    }

    public Tutor authenticateTutor(String name, String password){
        return SystemManager.verifyTutor(name, password);
    }

    public Student authenticateStudent(String name, String password){
        return SystemManager.verifyStudent(name, password);
    }

    public Result createStudent(String name, String password){
        if(SystemManager.findStudent(name) != null){
            return Result.DUPLICATE_NAME;
        }

        Student s = new Student(name, password);
        SystemManager.addStudent(s);
        SystemManager.save();

        return Result.OK;
    }

    public Result createTutor(String name, String password, String subject){
        if(SystemManager.findTutor(name) != null){
            return Result.DUPLICATE_NAME;
        }

        Tutor t = new Tutor(name, password, subject);
        SystemManager.addTutor(t);
        SystemManager.save();

        return Result.OK;
    }

    public Result createOpening(int start, int end, String date, Tutor t){
        Opening o = new Opening(start, end, date, t);

        if(t.hasConflict(o)){
            return Result.TIME_CONFLICT;
        }

        t.addOpening(o);
        SystemManager.addOpening(o);
        SystemManager.save();

        return Result.OK;
    }

    public ArrayList<Opening> searchOpenings(int start, String subject, String date){
        return SystemManager.searchOpenings(start, subject, date);
    }

    public ArrayList<Opening> openingsForTutor(Tutor t){
        return t.getAllOpenings();
    }

    public ArrayList<Opening> openingsForStudent(Student s){
        return s.getAllBookings();
    }

    public Result bookAppointment(Student s, int ID){
        Opening o = SystemManager.getOpen(ID);

        if(o == null){
            return Result.NO_SUCH_OPENING;
        }
        if(!o.isAvailable()){
            return Result.NOT_AVAILABLE;
        }
        if(s.checkBookings(ID)){
            return Result.ALREADY_BOOKED;
        }
        if(s.hasConflict(o)){
            return Result.TIME_CONFLICT;
        }

        o.setStudent(s);
        s.addOpening(o);
        SystemManager.save();

        return Result.OK;
    }

    public Result cancelAppointment(Student s, int ID){
        Opening o = SystemManager.getOpen(ID);

        if(o == null || o.getStudent() == null || !o.getStudent().getName().equals(s.getName())){
            return Result.NOT_BOOKED_BY_YOU;
        }

        o.setStudent(null);
        s.removeBooking(ID);
        SystemManager.save();

        return Result.OK;
    }
}
