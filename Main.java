import java.util.ArrayList;
import java.util.Scanner;
public class Main{

    private static final AppointmentService service = new AppointmentService();

    public static void main(String[] args){
        service.load();

        Scanner s = new Scanner(System.in);

        boolean running = true;

        while(running){
            printMain();

            int choice = readInt(s, "Enter your choice: ");

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

                    int start = readInt(s, "Enter start time in military time: ");
                    int end = readInt(s, "Enter end time in military time: ");
                    System.out.print("Enter date: ");
                    String date = s.nextLine();

                    createOpening(start, end, date, t);

                    break;
                case 4:
                    Student stud = studentLogin(s);
                    if (stud == null) break;

                    int searchStart = readInt(s, "Enter start time: ");
                    System.out.print("Enter subject: ");
                    String searchSubject = s.nextLine();
                    System.out.print("Enter date: ");
                    String searchDate = s.nextLine();

                    searchOpenings(searchStart, searchSubject, searchDate);

                    System.out.print("Would you like to book an appointment? (y/n): ");

                    if (s.nextLine().equalsIgnoreCase("y")) {
                        int id = readInt(s, "Enter Opening ID: ");
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
                        int cancelId = readInt(s, "Enter Opening ID to cancel: ");
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
        Result r = service.createStudent(name, password);

        if(r == Result.DUPLICATE_NAME){
            System.out.println("A student named " + name + " already exists.");
        }
    }

    public static void createTutor(String name, String password, String subject){
        Result r = service.createTutor(name, password, subject);

        if(r == Result.DUPLICATE_NAME){
            System.out.println("A tutor named " + name + " already exists.");
        }
    }

    public static void createOpening(int s, int e, String d, Tutor t){
        Result r = service.createOpening(s, e, d, t);

        if(r == Result.TIME_CONFLICT){
            System.out.println("You already have an opening at this time.");
        }
    }

    public static void searchOpenings(int s, String subject, String date){
        ArrayList<Opening> results = service.searchOpenings(s, subject, date);

        if(results.isEmpty()){
            System.out.println("No openings match that subject, date, and time.");
            return;
        }

        for(Opening o : results){
            System.out.println(o);
        }
    }

    public static void displayOpeningsForTutor(Tutor t){
        ArrayList<Opening> allOps = service.openingsForTutor(t);
        for(Opening o : allOps){
            System.out.println(o);
        }
    }

    public static void displayOpeningsForStudent(Student s){
        ArrayList<Opening> allOps = service.openingsForStudent(s);
        for(Opening o : allOps){
            System.out.println(o);
        }
    }

    public static void bookApps(Student s, int ID){
        Result r = service.bookAppointment(s, ID);

        switch(r){
            case NO_SUCH_OPENING:
                System.out.println("No such Opening");
                break;
            case NOT_AVAILABLE:
                System.out.println("not open");
                break;
            case ALREADY_BOOKED:
                System.out.println("You already booked this opening");
                break;
            case TIME_CONFLICT:
                System.out.println("You already have a booking at this time.");
                break;
            default:
                break;
        }
    }

    public static void cancelApp(Student s, int ID){
        Result r = service.cancelAppointment(s, ID);

        if(r == Result.NOT_BOOKED_BY_YOU){
            System.out.println("No such Opening has been booked by you");
        }
    }

    private static int readInt(Scanner s, String prompt){
        while(true){
            System.out.print(prompt);
            try{
                return Integer.parseInt(s.nextLine().trim());
            }
            catch(NumberFormatException e){
                System.out.println("That is not a whole number. Please try again.");
            }
        }
    }

    private static boolean adminLogin(Scanner s) {
        System.out.print("Enter Admin Password: ");
        String pass = s.nextLine();
        if (!service.authenticateAdmin(pass)) {
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

        Tutor t = service.authenticateTutor(name, password);
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

        Student stud = service.authenticateStudent(name, password);
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
