import java.util.ArrayList;
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        System.out.println("What would you like to do?");
        System.out.println("(1) Register new Student");
        System.out.println("(2) Register new Tutor");
        System.out.println("(3) Add an Opening");
        System.out.println("(4) Search Openings");
        System.out.println("(5) Book an Opening");
        System.out.println("(6) Cancel a Booking");
        System.out.print("Enter your choice: ");
        Scanner s = new Scanner(System.in);
        String choice = s.nextLine();

        if(choice == "1"){
            System.out.print("Log in with Admin Password: ");
            String adminPass = s.nextLine();
            String check = SystemManager.getAdminPassword();
            if(adminPass == check){
                System.out.println("Welcome Admin, please input student info to register them");
                System.out.println("Student Name: ");
                String name = s.nextLine();
                System.out.println("Student Password: ");
                String studentPassword = s.nextLine();

                addStudent(name, studentPassword);
            }
            else{
                System.out.println("not permitted");
            }
        }

        else if(choice == "2"){
            System.out.print("Log in with Admin Password: ");
            String adminPass = s.nextLine();
            String check = SystemManager.getAdminPassword();
            if(adminPass == check){
                System.out.println("Welcome Admin, please input tutor info to register them");
                System.out.println("Tutor Name: ");
                String name = s.nextLine();
                System.out.println("Tutor Password: ");
                String tutorPassword = s.nextLine();
                System.out.println("Tutor Subject: ");
                String tutorSubject = s.nextLine();

                addTutor(name, tutorPassword, tutorSubject);
            }
            else{
                System.out.println("not permitted");
            }
        }

        else if(choice == "3"){
            System.out.println("Please log in");
            System.out.println("Name: ");
            String name = s.nextLine();
            System.out.println("Password: ");
            String password = s.nextLine();
            
            Tutor t1 = null;
            boolean verify = false;
            for(Tutor t : SystemManager.getAllTutors()){
                if(name == t.getName()){
                    if(password == t.getPassword()){
                        verify = true;
                        t1 = t;
                    }
                }
            }

            if(verify){
                System.out.println("Hello " + name);
                System.out.println("Here are your current availabilities: ");
                showOpeningsForTutor(t1);
                System.out.println("What is the starting hour of your new availability?: ");
                int start = s.nextInt();
                System.out.println("What is the ending hour of your new availability?: ");
                int end = s.nextInt();
                System.out.println("What is the date of your new availability?: ");
                String date = s.nextLine();

                addOpening(start, end, date, t1);
            }
            else{
                System.out.println("not permitted");
            }
        }

        else if(choice == 4){
            System.out.println("Please log in");
            System.out.println("Name: ");
            String name = s.nextLine();
            System.out.println("Password: ");
            String password = s.nextLine();
            
            Student s1 = null;
            boolean verify = false;
            for(Student st : SystemManager.getAllStudents()){
                if(name == st.getName()){
                    if(password == st.getPassword()){
                        verify = true;
                        s1 = st;
                    }
                }
            }

            if(verify){
                System.out.println("Hello" + name);
                System.out.println("Please indicate the time of session you want: ");
                int start = s.nextInt();

                System.out.println("Please indicate the subject of session you want: ");
                String subject = s.nextLine();

                System.out.println("Please indicate the date of session you want: ");
                String date = s.nextLine();

                System.out.println(searchOpenings(start, subject, date));
            }
            else{
                System.out.println("not permitted");
            }
        }
    }

    public static void addStudent(Sting name, String studentPassword){
        Student student1 = new Student(name, studentPassword);
        SystemManager.getAllStudents().add(student1);
    }

    public static void addTutor(Sting name, String tutorPassword, String subject){
        Tutor tutor1 = new Tutor(name, tutorPassword, subject);
        SystemManager.getAllTutors().add(tutor1);
    }

    public static void addOpening(int s, int e, String d, Tutor t){
        Opening opening1 = new Opening(s, e, d, t);
        t1.getOpenings().add(opening1);
        SystemManager.getAllOpenings().add(opening1);
    }

    public static void showOpeningsForTutor(Tutor t){
        System.out.println(t.getOpenings());
    }

    public static ArrayList<Opening> searchOpenings(int time, String subject, String date){
        return SystemManager.search(time, subject, date);
    }
}
