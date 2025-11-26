import java.util.Scanner;

public class LogIn {

    static Scanner scanner = new Scanner(System.in);

    static final String adminPassword = "admin";

    public static void LogInAsAnAdmin() {
        System.out.print("Please enter the admin password: ");
        String password = scanner.nextLine();

        if(CompareAdminPassword(password)){
            System.out.println("Access verified. ");
            System.out.println("Welcome, admin!");
            System.out.println();

            MainMenu.StartingMenuAsAnAdmin();
        }
        else {
            System.out.println("Wrong password. ");
            System.out.println();

            MainMenu.StartingMenuWithoutLogIn();
        }
    }

    private static boolean CompareAdminPassword(String password) {
        return password.equals(adminPassword);
    }


    public static void LogInAsAnTeacher(){
        System.out.print("Welcome, teacher! Please enter your username: ");
        String username = scanner.nextLine();

        for (Teacher teacher : Teacher.teacherInstances) {
            if (username.equals(teacher.username)){
                System.out.print("User found. Please verify with your personal password: ");
                String password = scanner.nextLine();
                if (password.equals(teacher.personalPassword)){
                    System.out.println("Welcome, " + teacher.name + "!");
                    System.out.println();

                    MainMenu.StartingMenuAsAnTeacher(teacher);
                }
                else {
                    System.out.println("Password is not matching. ");
                    System.out.println();

                    MainMenu.StartingMenuWithoutLogIn();
                }
            }
        }

        System.out.println("User not found. ");
        System.out.println();

        MainMenu.StartingMenuWithoutLogIn();
    }
}
