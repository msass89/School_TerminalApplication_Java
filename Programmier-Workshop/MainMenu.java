
import java.util.Scanner;

public class MainMenu {

    static Scanner scanner = new Scanner(System.in);

    public static void StartingMenuWithoutLogIn() {
        boolean enteredAValidMenuOption = false;

        while (!enteredAValidMenuOption) {
            System.out.println("Please enter '1' for log in as an admin");
            System.out.println("Please enter '2' for log in as a teacher");
            System.out.print("Please enter a number: ");

            String optionInput = scanner.nextLine();

            switch (optionInput) {
                case "1" -> {
                    enteredAValidMenuOption = true;
                    System.out.println("Log in as an admin");
                    LogIn.LogInAsAnAdmin();
                }
                case "2" -> {
                    System.out.println("Log in as a teacher");
                    enteredAValidMenuOption = true;
                    LogIn.LogInAsAnTeacher();
                }
                default -> {
                    System.out.println(optionInput + " is not a valid option");
                    StartingMenuWithoutLogIn();
                }
            }
        }
    }

    public static void StartingMenuAsAnAdmin() {
        boolean enteredAValidMenuOption = false;

        while (!enteredAValidMenuOption) {
            System.out.println("Please enter '1' show a list of all teachers");
            System.out.println("Please enter '2' for creating a new teacher");
            System.out.println("Please enter '3' show a list of all students");
            System.out.println("Please enter '4 for creating a new student");
            System.out.println("Please enter '5' for log out");
            System.out.print("Please enter a number: ");

            String optionInput = scanner.nextLine();

            switch (optionInput) {
                case "1" -> Teacher.PrintTeacherList();
                case "2" -> {
                    enteredAValidMenuOption = true;
                    System.out.println("Create a new teacher");
                    CreateUser.CreateNewTeacher();
                }
                case "3" -> Student.PrintStudentList();
                case "4" -> {
                    enteredAValidMenuOption = true;
                    System.out.println("Create a new student");
                    CreateUser.CreateNewStudent(true);
                }
                case "5" -> StartingMenuWithoutLogIn();
                default -> {
                    System.out.println(optionInput + " is not a valid option");
                    StartingMenuAsAnAdmin();
                }
            }
        }
    }

    public static void StartingMenuAsAnTeacher(Teacher teacher) {
        boolean enteredAValidMenuOption = false;

        while (!enteredAValidMenuOption) {
            System.out.println("Please enter '1' show a list of all students");
            System.out.println("Please enter '2' for creating a new student");
            System.out.println("Please enter '3' to show the students learning status");
            System.out.println("Please enter '4' for changing the learning status");
            System.out.println("Please enter '5' for log out");
            System.out.print("Please enter a number: ");

            String optionInput = scanner.nextLine();

            switch (optionInput) {
                case "1" -> teacher.GetStudentList();
                case "2" -> {
                    enteredAValidMenuOption = true;
                    System.out.println("Create a new student");
                    CreateUser.CreateNewStudent(teacher);
                }
                case "3" -> teacher.getLearningStatus();
                case "4" -> teacher.SetLearningStatus();
                case "5" -> StartingMenuWithoutLogIn();
                default -> {
                    System.out.println(optionInput + " is not a valid option");
                    StartingMenuAsAnTeacher(teacher);
                }
            }
        }
    }
}
