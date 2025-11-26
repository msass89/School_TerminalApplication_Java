import java.util.Scanner;

public class CreateUser {

    static Scanner scanner = new Scanner(System.in);

    //static boolean ageIsAValidInteger = false;

    public static void CreateNewTeacher(){
        System.out.print("Please enter the teachers name: ");
        String name = scanner.nextLine();

        int age = GetAge();

        System.out.print("Please choose a user name: ");
        String username = scanner.nextLine();

        System.out.print("Please choose a personal password: ");
        String personalPassword = scanner.nextLine();

        new Teacher(name, age, username, personalPassword, true);
    }

    public static void CreateNewStudent(boolean asAnAdmin){
        System.out.print("Please enter the students name: ");
        String name = scanner.nextLine();
        System.out.print("Please enter the students age: ");
        int age = GetAge();

        new Student(name, age, asAnAdmin);
    }

    public static void CreateNewStudent(Teacher teacher){
        System.out.print("Please enter the students name: ");
        String name = scanner.nextLine();
        System.out.print("Please enter the students age: ");
        int age = GetAge();

        new Student(name, age,  teacher);
    }

    private static int GetAge(){
        boolean ageIsAValidInteger = false;
        int age = 0;

        while(!ageIsAValidInteger){
            System.out.print("Please enter the teachers age: ");
            String ageInput = scanner.nextLine();
            try {
                age = Integer.parseInt(ageInput);
                ageIsAValidInteger = true;
            }
            catch (NumberFormatException e) {
                System.out.println(ageInput + " is not a valid integer");
            }
        }
        return age;
    }
}
