import java.util.ArrayList;
import java.util.Scanner;
public class Main{
    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args){
        SystemManager.load();

        Scanner s = new Scanner(System.in);

        boolean running = true;

        while(running){
            printMain();

            int choice = Integer.parseInt(s.nextLine());

            switch(choice){
                case 1:
                    if(!adminLogin(s)) break;

                    System.out.print("Enter Student name: ");
                    String sName = s.nextLine();
                    System.out.print("Enter Student password: ");
                    String sPass = s.nextLine();

                    createStudent(sName, sPass);

                    break;
                case 2:
                    if(!adminLogin(s)) break;

                    System.out.print("Enter Tutor name: ");
                    String tName = s.nextLine();
                    System.out.print("Enter Tutor password: ");
                    String tPass = s.nextLine();
                    System.out.print("Enter Tutor subject: ");
                    String subject = s.nextLine();

                    createTutor(tName, tPass, subject);

                    break;
                case 3:
                    Tutor t = tutorLogin(s);
                    if (t == null) break;

                    System.out.print("Enter start time in military time: ");
                    int start = Integer.parseInt(s.nextLine());
                    System.out.print("Enter end time in military time: ");
                    int end = Integer.parseInt(s.nextLine());
                    System.out.print("Enter date: ");
                    String date = s.nextLine();

                    createOpening(start, end, date, t);

                    break;
                case 4:
                    Student stud = studentLogin(s);
                    if (stud == null) break;

                    System.out.print("Enter start time: ");
                    int searchStart = Integer.parseInt(s.nextLine());
                    System.out.print("Enter subject: ");
                    String searchSubject = s.nextLine();
                    System.out.print("Enter date: ");
                    String searchDate = s.nextLine();

                    searchOpenings(searchStart, searchSubject, searchDate);

                    System.out.print("Would you like to book an appointment? (y/n): ");

                    if (s.nextLine().equalsIgnoreCase("y")) {
                        System.out.print("Enter Opening ID: ");
                        int id = Integer.parseInt(s.nextLine());
                        bookApps(stud, id);
                    }

                    break;
                case 5:
                    Tutor tDisplay = tutorLogin(s);
                    if(tDisplay == null) break;
                    displayOpeningsForTutor(tDisplay);
                    
                    break;
                case 6:
                    Student sDisplay = studentLogin(s);
                    if(sDisplay == null) break;
                    displayOpeningsForStudent(sDisplay);

                    System.out.print("Would you like to cancel a booking? (y/n): ");
                    if (s.nextLine().equalsIgnoreCase("y")) {
                        System.out.print("Enter Opening ID to cancel: ");
                        int cancelId = Integer.parseInt(s.nextLine());
                        cancelApp(sDisplay, cancelId);
                    }

                    break;
                case 7: 
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Please choose a number from 1 to 7.");
                    break;
            }

        }
    }

    public static void createStudent(String name, String password){
        if(SystemManager.findStudent(name) != null){
            System.out.println("A student named " + name + " already exists.");
            return;
        }

        Student s = new Student(name, password);
        SystemManager.addStudent(s);
        SystemManager.save();
    }

    public static void createTutor(String name, String password, String subject){
        if(SystemManager.findTutor(name) != null){
            System.out.println("A tutor named " + name + " already exists.");
            return;
        }

        Tutor t = new Tutor(name, password, subject);
        SystemManager.addTutor(t);
        SystemManager.save();
    }

    public static void createOpening(int s, int e, String d, Tutor t){
        Opening o = new Opening(s, e, d, t);

        if(t.hasConflict(o)){
            System.out.println("You already have an opening at this time.");
            return;
        }

        t.addOpening(o);
        SystemManager.addOpening(o);
        SystemManager.save();
    }

    public static void searchOpenings(int s, String subject, String date){
        ArrayList<Opening> results = SystemManager.searchOpenings(s, subject, date);

        if(results.isEmpty()){
            System.out.println("No openings match that subject, date, and time.");
            return;
        }

        for(Opening o : results){
            System.out.println(o);
        }
    }

    public static void displayOpeningsForTutor(Tutor t){
        ArrayList<Opening> allOps = t.getAllOpenings();
        for(Opening o : allOps){
            System.out.println(o);
        }
    }

    public static void displayOpeningsForStudent(Student s){
        ArrayList<Opening> allOps = s.getAllBookings();
        for(Opening o : allOps){
            System.out.println(o);
        }
    }

    public static void bookApps(Student s, int ID){
        Opening o = SystemManager.getOpen(ID);
        if(o == null){
            System.out.println("No such Opening");
            return;
        }
        boolean result = o.isAvailable();
        if(result != true){
            System.out.println("not open");
            return;
        }
        if(s.checkBookings(ID)){
            System.out.println("You already booked this opening");
            return;
        }
        if(s.hasConflict(o)){
            System.out.println("You already have a booking at this time.");
            return;
        }

        o.setStudent(s);
        s.addOpening(o);
        SystemManager.save();
    }

    public static void cancelApp(Student s, int ID){
        Opening o = SystemManager.getOpen(ID);
        if(o == null || o.getStudent() == null || !o.getStudent().getName().equals(s.getName())){
            System.out.println("No such Opening has been booked by you");
            return;
        }
        o.setStudent(null);
        s.removeBooking(ID);
        SystemManager.save();
    }

    private static boolean adminLogin(Scanner s) {
        System.out.print("Enter Admin Password: ");
        String pass = s.nextLine();
        if (!pass.equals(SystemManager.getAdminPass())) {
            System.out.println("Incorrect Admin Password.");
            return false;
        }
        return true;
    }

    private static Tutor tutorLogin(Scanner s) {
        System.out.print("Enter Tutor name: ");
        String name = s.nextLine();
        System.out.print("Enter Tutor password: ");
        String password = s.nextLine();

        Tutor t = SystemManager.verifyTutor(name, password);
        if (t == null) {
            System.out.println("No such tutor profile or incorrect password.");
        }
        return t;
    }

    private static Student studentLogin(Scanner s) {
        System.out.print("Enter Student name: ");
        String name = s.nextLine();
        System.out.print("Enter Student password: ");
        String password = s.nextLine();

        Student stud = SystemManager.verifyStudent(name, password);
        if (stud == null) {
            System.out.println("No such student profile or incorrect password.");
        }
        return stud;
    }

    public static void printMain(){
        System.out.println("Hello, what would you like to do: ");
        System.out.println("(1) create a student profile");
        System.out.println("(2) create a tutor profile");
        System.out.println("(3) create a an opening");
        System.out.println("(4) search for an opening");
        System.out.println("(5) display openings for tutor");
        System.out.println("(6) display openings for student");
        System.out.println("(7) quit");
    }
}
