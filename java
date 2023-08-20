import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Student {
    public String name;
    public int age;
    public String grade;

    Student(String name, int age, String grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }
}



class Main {
    public static void main(String[] args) {
        List<Student> stu = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter student details or 'exit' to quit:");

        while (true) {
            
            System.out.print("Name: ");
            String name = scanner.nextLine();

            if (name.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.print("Age: ");
            int age = Integer.parseInt(scanner.nextLine());

            System.out.print("Grade: ");
            String grade = scanner.nextLine();

            Student students = new Student(name, age, grade);
            stu.add(students);
        }

        System.out.println("Student Details:");
        for (Student students : stu) {
            System.out.println("Name: " + students.name + ", Age: " + students.age + ", Grade: " + students.grade);
        }
    }
}
