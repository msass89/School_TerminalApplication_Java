import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Teacher {

    public static final List<Teacher> teacherInstances = new ArrayList<>();

    private static final Scanner scanner = new Scanner(System.in);

    String name;
    int age;
    String username;
    String personalPassword;

    public Teacher(String name, int age, String username, String personalPassword, boolean asAdmin) {
        this.name = name;
        this.age = age;
        this.username = username;
        this.personalPassword = personalPassword;
        teacherInstances.add(this);

        if(asAdmin){
            System.out.println("New teacher created successfully");
            System.out.println();
            MainMenu.StartingMenuAsAnAdmin();
        }
    }

    public static void PrintTeacherList() {
        System.out.println();
        System.out.println("Registered teachers");
        for(Teacher teacher : teacherInstances) {
            System.out.println("Name: " + teacher.name +  ", Age: " + teacher.age + ", Username: " + teacher.username);
        }
        System.out.println();
    }

    public void SetLearningStatus() {
        Student.setLearningStatus(name);
    }

    public void getLearningStatus() {
        if(Student.getLearningStatus()){
            System.out.println();
            System.out.println("Students are learning.");
        }
        else{
            System.out.println();
            System.out.println("Students are not learning.");
        }

        System.out.println();
    }

    public void GetStudentList() {
        Student.PrintStudentList();
    }
}
