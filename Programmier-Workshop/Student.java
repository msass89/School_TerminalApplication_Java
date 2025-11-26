import java.util.ArrayList;
import java.util.List;

public class Student {

    private static final List<Student> studentInstances = new ArrayList<>();
    private static boolean IsLearning;

    String name;
    int age;
    boolean isLearning;


    public Student(String name, int age, boolean asAnAdmin) {
        this.name = name;
        this.age = age;
        this.isLearning = false;
        studentInstances.add(this);

        if(asAnAdmin) {
            System.out.println("New student created successfully");
            System.out.println();
            MainMenu.StartingMenuAsAnAdmin();
        }
    }

    public Student(String name, int age, Teacher teacher) {
        this.name = name;
        this.age = age;
        this.isLearning = false;
        studentInstances.add(this);
        System.out.println("New student created successfully");
        System.out.println();

        MainMenu.StartingMenuAsAnTeacher(teacher);
    }

    public static void PrintStudentList() {
        System.out.println();
        System.out.println("Registered students:");
        for(Student student : studentInstances) {
            System.out.println("Name: " + student.name +  ", Age: " + student.age);
        }
        System.out.println();
    }

    public static boolean getLearningStatus(){
        return IsLearning;
    }

    public static void setLearningStatus(String teachersName) {
        System.out.println("Access verified. ");

        IsLearning = !IsLearning;

        System.out.println(teachersName + " changed the learning status of the students");

        for (Student student : studentInstances) {
            student.isLearning = IsLearning;

            if(student.isLearning) {
                System.out.println(student.name + " is now learning");
            }
            else{
                System.out.println(student.name + " is not learning anymore");
            }

        }

        System.out.println();
    }
}

