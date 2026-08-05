import java.util.ArrayList;
import java.util.Scanner;
public class Main{

    public void addStudent(Sting name, String studentPassword){
        Student student1 = new Student(name, studentPassword);
    }
    
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

                Student tutor1 = new Student(name, tutorPassword, tutorSubject);
            }
            else{
                System.out.println("not permitted");
            }
        }

        else if(choice == "3"){

        }
    }
}
